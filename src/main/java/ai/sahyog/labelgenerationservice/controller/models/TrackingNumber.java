package ai.sahyog.labelgenerationservice.controller.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TrackingNumber implements Serializable {

    @NotEmpty
    private String type;
    @NotEmpty
    private String value;
}
