package ai.sahyog.labelgenerationservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class LabelTemplateResolver extends StringTemplateResolver {

    //private final TemplateFetcher templateFetcher;

    public LabelTemplateResolver() {
        //this.templateFetcher = templateFetcher;
        this.setTemplateMode(TemplateMode.TEXT);
    }

    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate, String templateName, Map<String, Object> templateResolutionAttributes) {

        // Template name is in form of (carrierCode-accountNumber-origin.type)
        // We store that data in different columns, so split that fields and try to fetch template from DB
        String[] splitByDotParts = templateName.split("\\.");
        String type = splitByDotParts[1];
        String[] templateNameParts = splitByDotParts[0].split("-");
        String carrierCode = templateNameParts[0];
        String accountNumber = templateNameParts[1];
        String origin = templateNameParts[2];

        //Template template = templateFetcher.fetchTemplateData(carrierCode, type, accountNumber, origin);

        /*if (template == null) {
            log.error("Can not find template with following properties: carrierCode {}, type {}, accountNumber {}, origin {}", carrierCode, type, accountNumber, origin);
            return null;
        }*/
        // From client we get template in format %placeholder%. We do not want to change it in db, but on loading template
        // we adjust template for java library to populate template. We change placeholder to format ('[[${}]]')
        String content = null;
        try {
            File file  = ResourceUtils.getFile("classpath:templates/"+templateName);
            //Read File Content
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pattern pattern = Pattern.compile("%(?<placeholder>[A-Za-z.0-9]+)%");

        Matcher matcher = pattern.matcher(content);

        String templateContent = matcher.replaceAll("[(\\${${placeholder}})]");
        // Remove all tabs and new lines
        templateContent = templateContent.replaceAll("[\\t]", "");
        log.info("Reformatted template: [{}]", templateContent);

        return super.computeTemplateResource(configuration, ownerTemplate, templateContent, templateResolutionAttributes);
    }
}