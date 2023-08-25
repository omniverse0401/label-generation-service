package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class LabelResponse implements Serializable {

    @JsonProperty("accountNumber")
    @Schema(example = "243568", required = true, description = "")
    private String accountNumber;

    @JsonProperty("trackingNumber")
    @Schema(example = "000000000001231223123123", required = true, description = "")
    private String trackingNumber;

    @JsonProperty("origin")
    @Schema(example = "CLIENT_LOCATION", required = true, description = "")
    private String origin;

    @JsonProperty("labelType")
    private String labelType;

    @JsonProperty("labelData")
    private String labelData;

    @JsonProperty("reference1")
    private String reference1;

    @JsonProperty("reference2")
    private String reference2;

    @JsonProperty("reference3")
    private String reference3;
}
