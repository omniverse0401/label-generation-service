package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    @JsonProperty("firstName")
    @Size(max = 20)
    private String firstName;

    @JsonProperty("lastName")
    @Size(max = 20)
    private String lastName;

    @JsonProperty("addressLine1")
    @Size(min = 5, max = 30)
    @NotEmpty(message = "Field is missing")
    private String addressLine1;

    @JsonProperty("addressLine2")
    @Size(max = 30)
    private String addressLine2;

    @JsonProperty("city")
    @Size(max = 30)
    @NotEmpty(message = "Field is missing")
    private String city;

    @JsonProperty("state")
    @NotEmpty(message = "Field is missing")
    private String state;

    @JsonProperty("zipCode")
    @Pattern(regexp = "[0-9]{5}", message = "Only 5 digits are allowed")
    @Schema(example = "12345")
    @NotEmpty(message = "Field is missing")
    private String zipCode;

    @JsonProperty("phoneNo")
    @Schema(example = "0123456664")
    @Pattern(regexp = "[0-9 \\+ \\- \\( \\)]*", message = "Phone number should contain only digits, +, -, (, )")
    @Size(max = 15, message = "Phone number should not be more than 15 digits")
    private String phoneNo;

}
