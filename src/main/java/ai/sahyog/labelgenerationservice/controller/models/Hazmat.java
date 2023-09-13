package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Hazmat implements Serializable {

    @JsonProperty("hazard_class")
    private String hazardClass;

}
