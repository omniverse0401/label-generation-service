package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class ShipmentRequest implements Serializable {

    @JsonProperty("shipment_id")
    String shipmentId;
    @JsonProperty("shipper_id")
    String shipperId;
    @JsonProperty("origin_location")
    String originLocation;
    @JsonProperty("shipment_date")
    String shipDate;
    Collection<Parcel> parcel;
    Collection<Address> address;
    Collection<Metadata> metadata;

}
