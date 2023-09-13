package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum WeightUom {

    G("g"),
    OZ("oz"),
    LB("lb"),
    KG("kg");

    @Getter
    private final String value;

    WeightUom(String value) {this.value = value;}

    @JsonCreator
    public static WeightUom fromValue(String text) {
        for (WeightUom b : WeightUom.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
