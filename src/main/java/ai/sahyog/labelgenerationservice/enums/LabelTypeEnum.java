package ai.sahyog.labelgenerationservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum LabelTypeEnum {
    ZPL("ZPL"),
    GIF("GIF"),
    PDF("PDF");

    @Getter
    private final String value;

    LabelTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static LabelTypeEnum fromValue(String text) {
        for (LabelTypeEnum b : LabelTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text.toUpperCase())) {
                return b;
            }
        }
        return null;
    }
}
