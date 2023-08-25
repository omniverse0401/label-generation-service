package ai.sahyog.labelgenerationservice.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TrackingNumberDto implements Serializable {

    private String type;
    private String value;
}
