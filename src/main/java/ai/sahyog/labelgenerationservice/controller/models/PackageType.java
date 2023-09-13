package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum PackageType {

    BOX("01"),
    ENVELOPE("02"),
    BAG("03");

    @Getter
    private final String value;

    PackageType(String value) {this.value = value;}

    @JsonCreator
    public static PackageType fromValue(String text) {
        for (PackageType b : PackageType.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
