package ai.sahyog.labelgenerationservice.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum WeightUomEnum {

    LB("lb"),
    OZ("oz"),
    KG("kg");


    @Getter
    private final String value;

    WeightUomEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static WeightUomEnum fromValue(String text) {
        for (WeightUomEnum b : WeightUomEnum.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }
}
