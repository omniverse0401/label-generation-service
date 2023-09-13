package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum RecipientType {

    LICENSEE("01"),
    CONSUMER("02");
    @Getter
    private final String value;

    RecipientType(String value) {this.value = value;}

    @JsonCreator
    public static RecipientType fromValue(String text) {
        for (RecipientType b : RecipientType.values()) {
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
