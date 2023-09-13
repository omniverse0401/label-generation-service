package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Parcel implements Serializable {

    @JsonProperty("parcel_id")
    String parcelId;
    @JsonProperty("package_type")
    PackageType packageType;
    @JsonProperty("predefined_package")
    String predefinedPackage;
    Dimensions dimensions;
    @JsonProperty("shipping_options")
    ShippingOptions shippingOptions;
    @JsonProperty("printing_options")
    PrintingOptions printingOptions;
    @JsonProperty("label_url")
    String label_url;
    @JsonProperty("label_data")
    String label_data;
    String zone;
    Collection<Rate> rate;
    Content content;
    Collection<Carrier> carrier;
    Collection<ErrorResponse> error;

}
