package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Rate implements Serializable {

    @JsonProperty("service_code")
    String serviceCode;
    @JsonProperty("estimated_delivery_date")
    String estimatedDeliveryDate;
    @JsonProperty("dim_weight")
    Double dimWeight;
    @JsonProperty("billed_weight")
    Double billedWeight;
    @JsonProperty("total_price")
    Price totalPrice;
    @JsonProperty("price_list")
    Collection<Price> priceList;


}
