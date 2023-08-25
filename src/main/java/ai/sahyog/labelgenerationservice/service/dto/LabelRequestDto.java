package ai.sahyog.labelgenerationservice.service.dto;

import ai.sahyog.labelgenerationservice.LabelTypeEnum;
import ai.sahyog.labelgenerationservice.ServiceEnum;
import ai.sahyog.labelgenerationservice.ServiceLevel;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class LabelRequestDto {

    private String accountNumber;
    private ServiceEnum serviceCode;
    private ServiceLevel serviceLevel;
    private String origin;
    private String weightUom;
    private String dimensionUom;
    private Double weight;
    private Double length;
    private Double height;
    private Double width;
    private LabelTypeEnum labelType;
    private LocalDate shipDate;
    private LocalDate requestedDeliveryDate;
    private LocalDate estimatedDeliveryDate;
    private String reference1;
    private String reference2;
    private String reference3;
    private AddressDto destinationAddress;
    private AddressDto returnAddress;
    private AddressDto originAddress;
    private List<TrackingNumberDto> trackingNumbers;
    private Map<String, Object> extSortCodes;
    private Map<String, String> intSortCodes;
    private OriginExtSortCodeDto originExtSortCodeDto;
    private String carrierFacility;
    private boolean isUniversalCarrier;

}
