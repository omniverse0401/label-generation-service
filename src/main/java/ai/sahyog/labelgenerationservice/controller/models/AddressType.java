package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum AddressType {

    RESIDENTIAL("residential"),
    COMMERCIAL("commercial"),
    WAREHOUSE("warehouse");

    @Getter
    private final String value;

    AddressType(String value) {this.value = value;}

    @JsonCreator
    public static AddressType fromValue(String text) {
        for (AddressType b : AddressType.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
