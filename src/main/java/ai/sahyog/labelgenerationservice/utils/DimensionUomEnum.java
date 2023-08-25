package ai.sahyog.labelgenerationservice.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum DimensionUomEnum {

    IN("in"),
    CM("cm");

    @Getter
    private final String value;

    DimensionUomEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DimensionUomEnum fromValue(String text) {
        for (DimensionUomEnum b : DimensionUomEnum.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }
}
