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

    private String name;
    private String company;
    @JsonProperty("line_1")
    private String addressLine1;
    @JsonProperty("line_2")
    private String addressLine2;
    @JsonProperty("line_3")
    private String addressLine3;
    @JsonProperty("city")
    private String city;
    private String state;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String phone;
    private String email;
    private String instruction;
    @JsonProperty("address_type")
    private AddressType addressType;
    @JsonProperty("address_purpose")
    private AddressPurpose addressPurpose;
    private AddressValidationStatus validate;


}
