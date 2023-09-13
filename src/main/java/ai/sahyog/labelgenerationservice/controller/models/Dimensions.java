package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Dimensions implements Serializable {

    Double length;
    Double width;
    Double height;
    @JsonProperty("dimensions_uom")
    DimensionUom dimensionsUom;
    @JsonProperty("dimensional_weight")
    Double dimensionalWeight;
    Double weight;
    @JsonProperty("weight_uom")
    WeightUom weightUom;
}
