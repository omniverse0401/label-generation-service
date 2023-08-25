package ai.sahyog.labelgenerationservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

@Configuration
public class TemplateConfig {

    final LabelTemplateResolver labelTemplateResolver;

    public TemplateConfig(LabelTemplateResolver labelTemplateResolver) {
        this.labelTemplateResolver = labelTemplateResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(labelTemplateResolver);
        return templateEngine;
    }
}