package ai.sahyog.labelgenerationservice.controller.models;

import ai.sahyog.labelgenerationservice.ServiceEnum;
import ai.sahyog.labelgenerationservice.ServiceLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class LabelRequest implements Serializable {
    @JsonProperty("accountNumber")
    @Schema(example = "43568", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotEmpty(message = "Field is missing")
    @Pattern(regexp = "[0-9]+", message = "Account number should contain only digits")
    private String accountNumber;

    @JsonProperty("serviceCode")
    @Schema(example = "GXC_E",requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    private ServiceEnum serviceCode;

    @JsonProperty("serviceLevel")
    @Schema(example = "GROUND", requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    private ServiceLevel serviceLevel;

    @JsonProperty("origin")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotEmpty(message = "Field is missing")
    private String origin;

    @JsonProperty("weight_uom")
    @Schema(example = "lb", requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    //@WeightUomEnumTypeSubset(anyOf = {WeightUomEnum.LB, WeightUomEnum.KG, WeightUomEnum.OZ})
    private String weightUom;

    @JsonProperty("dimension_uom")
    @Schema(example = "in", requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    //@DimensionUomEnumTypeSubset(anyOf = {DimensionUomEnum.CM, DimensionUomEnum.IN})
    private String dimensionUom;

    @JsonProperty("weight")
    @Schema(example = "4.23", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotNull(message = "Field is missing")
    @Positive(message = "Only positive values are allowed")
    private Double weight;

    @JsonProperty("length")
    @Schema(example = "2.8", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotNull(message = "Field is missing")
    @Positive(message = "Only positive values are allowed")
    @Digits(integer = 10, fraction = 4)
    private Double length;

    @JsonProperty("height")
    @Schema(example = "3.2", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotNull(message = "Field is missing")
    @Positive(message = "Only positive values are allowed")
    @Digits(integer = 10, fraction = 4)
    private Double height;

    @JsonProperty("width")
    @Schema(example = "2.1", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotNull(message = "Field is missing")
    @Positive(message = "Only positive values are allowed")
    @Digits(integer = 10, fraction = 4)
    private Double width;

    @JsonProperty("labelType")
    @Schema(example = "ZPL", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
    @NotNull(message = "Field should be {GIF, ZPL, PDF}")
    private String labelType;

    @JsonProperty("shipDate")
    @Schema(description = "")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate shipDate = null;

    @JsonProperty("requestedDeliveryDate")
    @Schema(description = "")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate requestedDeliveryDate = null;

    @JsonProperty("reference1")
    @Size(max = 30)
    private String reference1 = null;

    @JsonProperty("reference2")
    @Size(max = 30)
    private String reference2 = null;

    @JsonProperty("reference3")
    @Size(max = 30)
    private String reference3 = null;

    @JsonProperty("destinationAddress")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    @NotNull(message = "Field is missing")
    @Valid
    private Address destinationAddress;
    @JsonProperty("returnAddress")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    @NotNull(message = "Field is missing")
    @Valid
    private Address returnAddress;
    @JsonProperty("originAddress")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,  description = "")
    @NotNull(message = "Field is missing")
    @Valid
    private Address originAddress;

    @Valid
    private List<TrackingNumber> trackingNumbers;

}
