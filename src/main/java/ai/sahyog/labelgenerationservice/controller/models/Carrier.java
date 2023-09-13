package ai.sahyog.labelgenerationservice.controller.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Carrier implements Serializable {

    String code;
    String scac;
    String type;
}
