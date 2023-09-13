package ai.sahyog.labelgenerationservice.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PrintingOptions implements Serializable {

    @JsonProperty("label_format")
    String labelFormat;
    @JsonProperty("label_type")
    String labelType;
    @JsonProperty("printer_model")
    String printerModel;

}
