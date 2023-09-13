package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum AddressPurpose {

    ORIGIN("orgin"),
    DESTINATION("destination"),
    RETURN("return"),
    SENDER("sender"),
    BILLING("billing");

    @Getter
    private final String value;

    AddressPurpose(String value) {this.value = value;}

    @JsonCreator
    public static AddressPurpose fromValue(String text) {
        for (AddressPurpose b : AddressPurpose.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }
}
