package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum DimensionUom {
    IN("in"),
    CM("cm"),
    FT("ft"),
    MM("mm"),
    M("m"),
    YD("yd");

    @Getter
    private final String value;

    DimensionUom(String value) {this.value = value;}

    @JsonCreator
    public static DimensionUom fromValue(String text) {
        for (DimensionUom b : DimensionUom.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
