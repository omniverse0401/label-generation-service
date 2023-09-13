package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Content implements Serializable {

    Alcohol alcohol;
    Hazmat hazmat;
    @JsonProperty("dry_ice")
    DryIce dryIce;

}
