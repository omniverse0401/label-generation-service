package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum AddressValidationStatus {

    COMPLETED("completed"),
    BYPASS("bypass"),
    REGULAR("regular"),
    STRICT("strict");

    @Getter
    private final String value;

    AddressValidationStatus(String value) {this.value = value;}

    @JsonCreator
    public static AddressValidationStatus fromValue(String text) {
        for (AddressValidationStatus b : AddressValidationStatus.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }
}
