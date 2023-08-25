package ai.sahyog.labelgenerationservice.service.dto;

import lombok.Data;

@Data
public class OriginExtSortCodeDto {

    private long id;
    private String origin;
    private String carrierDestinationFacility;
    private String customerBranch;
    private String injectionZip;
    private String mailerId;
    private String seed;
    private String accountNumber;
    private String sgCode;
    private String postfix;

}