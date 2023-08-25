package ai.sahyog.labelgenerationservice.enums;

import lombok.Getter;

public enum TemplateType {
    HTML("html"),
    ZPL("zpl");

    @Getter
    private final String type;

    TemplateType(String type) {
        this.type = type;
    }

    public static TemplateType fromValue(String text) {
        for (TemplateType b : TemplateType.values()) {
            if (String.valueOf(b.type).equals(text)) {
                return b;
            }
        }
        return null;
    }
}