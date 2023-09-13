package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class DryIce implements Serializable {

    @JsonProperty("contains_dry_ice")
    boolean containsDryIce;
    Double weight;
    @JsonProperty("weight_uom")
    WeightUom weightUom;

}
