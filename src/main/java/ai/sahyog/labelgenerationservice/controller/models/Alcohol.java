package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Alcohol implements Serializable {

    @JsonProperty("contains_alcohol")
    boolean containsAlcohol;
    @JsonProperty("recipient_type")
    RecipientType recipientType;

}
