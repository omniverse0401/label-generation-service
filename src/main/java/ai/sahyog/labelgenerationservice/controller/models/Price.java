package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Price implements Serializable {
    Double amount;
    @JsonProperty("gross_amount")
    Double grossAmount;
    String currency;
    String type;
    String category;
    String reason;

}
