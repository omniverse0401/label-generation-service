package ai.sahyog.labelgenerationservice.controller.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorResponse implements Serializable {

    private String code;
    private String message;

}
