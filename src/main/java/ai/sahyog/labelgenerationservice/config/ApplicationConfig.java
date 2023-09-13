package ai.sahyog.labelgenerationservice.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thymeleaf.TemplateEngine;

@Configuration
@EnableConfigurationProperties({ApplicationProperties.class})
@Import({JacksonConfig.class})
public class ApplicationConfig {

    final LabelTemplateResolver labelTemplateResolver;

    public ApplicationConfig(LabelTemplateResolver labelTemplateResolver) {
        this.labelTemplateResolver = labelTemplateResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(labelTemplateResolver);
        return templateEngine;
    }

}