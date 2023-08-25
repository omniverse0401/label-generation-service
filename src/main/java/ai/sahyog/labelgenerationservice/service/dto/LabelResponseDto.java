package ai.sahyog.labelgenerationservice.service.dto;

import lombok.Data;

@Data
public class LabelResponseDto {

    private String accountNumber;
    private String trackingNumber;
    private String origin;
    private String labelType;
    private String labelData;
    private String reference1;
    private String reference2;
    private String reference3;

}
