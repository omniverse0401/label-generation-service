package ai.sahyog.labelgenerationservice.service.impl;


import ai.sahyog.labelgenerationservice.LabelTypeEnum;
import ai.sahyog.labelgenerationservice.ServiceEnum;
import ai.sahyog.labelgenerationservice.config.ApplicationProperties;
import ai.sahyog.labelgenerationservice.helpers.LabelDataPrepareHelper;
import ai.sahyog.labelgenerationservice.service.LabelService;
import ai.sahyog.labelgenerationservice.service.dto.LabelRequestDto;
import ai.sahyog.labelgenerationservice.service.dto.LabelResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
public class LabelServiceImpl implements LabelService {

    private static final String ZPL_EXTENSION = ".zpl";
    private static final String HTML_EXTENSION = ".html";

    @Autowired
    private LabelDataPrepareHelper labelDataPrepareHelper;

    @Autowired
    private ITemplateEngine templateEngine;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Mono<LabelResponseDto> generateLabel(LabelRequestDto labelRequestDto) {
        Map<String, Object> preparedData = labelDataPrepareHelper.prepareLabelData(labelRequestDto);
        String labelData = populateTemplate(labelRequestDto, preparedData);
        LabelResponseDto labelResponseDto = new LabelResponseDto();
        labelResponseDto.setLabelData(labelData);
        return Mono.just(labelResponseDto);
    }

    public String populateTemplate(LabelRequestDto labelRequest, Map<String, Object> preparedData) {
        LabelTypeEnum labelType = labelRequest.getLabelType();
        ServiceEnum serviceCode = labelRequest.getServiceCode();
        log.info("Label template with service code {} was used to generate label", serviceCode.getValue());
        String extension = labelType == LabelTypeEnum.ZPL ? ZPL_EXTENSION : HTML_EXTENSION;
        String origin = labelRequest.getOrigin();
        String populatedTemplate = templateEngine.process(serviceCode.getValue() + extension, new Context(
                Locale.getDefault(), preparedData));
        log.info("Populated template, content is: {}", populatedTemplate);
        if (labelType == LabelTypeEnum.ZPL && isOriginBase64Enabled(origin)) {
            populatedTemplate = populatedTemplate.replaceAll("[\\n]", "\r\n");
            populatedTemplate = Base64.getEncoder().encodeToString(populatedTemplate.getBytes());
            log.info("Additional encoded template content is: {}", populatedTemplate);
        } else {
            populatedTemplate = populatedTemplate.replaceAll("[\\n]", "");
        }
        return populatedTemplate;
    }

    private boolean isOriginBase64Enabled(String origin) {
        if (StringUtils.isBlank(origin)) return false;
        return (CollectionUtils.isEmpty(applicationProperties.getBase64ExclusionListForZpl())
                || !applicationProperties.getBase64ExclusionListForZpl().contains(origin));
    }

}
