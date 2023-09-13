package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class ShipmentResponse implements Serializable {

    @JsonProperty("shipment_id")
    String shipmentId;
    Collection<Parcel> parcel;
}
