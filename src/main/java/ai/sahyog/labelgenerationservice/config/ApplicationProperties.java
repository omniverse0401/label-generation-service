package ai.sahyog.labelgenerationservice.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;

@ConfigurationProperties(prefix = "ai.sahyog")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationProperties {

    private final TemplateMetadata templateMetadata = new TemplateMetadata();
    private final Swagger swagger = new Swagger();
    private final Collection<String> base64ExclusionListForZpl = new ArrayList<>();

    @Getter
    @Setter
    public static class TemplateMetadata {
        private final Map<String, List<String>> templateMetadataConfigMap = new HashMap<>();

    }

    @Getter
    @Setter
    public static class Swagger {
        final List<String> exclusions = new ArrayList<>();
        private String title;
        private String description;
        private String license;
        private String licenseUrl;
        private String termsOfServiceUrl;
        private String version;
        private String contactName;
        private String contactUrl;
        private String contactEmail;
    }


}
