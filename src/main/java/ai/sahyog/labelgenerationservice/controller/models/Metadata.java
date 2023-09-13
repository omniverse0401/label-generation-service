package ai.sahyog.labelgenerationservice.controller.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Metadata implements Serializable {

    private String key;
    private String value;

}
