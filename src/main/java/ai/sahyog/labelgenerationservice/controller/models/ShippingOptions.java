package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShippingOptions implements Serializable {

    @JsonProperty("service_code")
    String serviceCode;
    @JsonProperty("service_name")
    String serviceName;

    String confirmation;
    String endorsement;
    @JsonProperty("carbon_neutral")
    String carbonNeutral;
    @JsonProperty("saturday_delivery")
    String saturdayDelivery;

}
