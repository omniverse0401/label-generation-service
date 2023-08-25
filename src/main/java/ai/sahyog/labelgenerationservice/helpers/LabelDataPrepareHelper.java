package ai.sahyog.labelgenerationservice.helpers;

import ai.sahyog.labelgenerationservice.LabelTypeEnum;
import ai.sahyog.labelgenerationservice.config.ApplicationProperties;
import ai.sahyog.labelgenerationservice.service.dto.AddressDto;
import ai.sahyog.labelgenerationservice.service.dto.LabelRequestDto;
import ai.sahyog.labelgenerationservice.utils.DimensionUtility;
import ai.sahyog.labelgenerationservice.utils.WeightUtility;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Slf4j
public class LabelDataPrepareHelper {

    private static final DateTimeFormatter expectedDeliveryDateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss a");
    private static final DateTimeFormatter shipDateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static final String ID = "UUID";
    private static final String ZPL_EXTENSION = "zpl";
    private static final String HTML_EXTENSION = "html";
    private static final String NAME = "Name";
    private static final String ADDRESS_1 = "Address1";
    private static final String ADDRESS_2 = "Address2";
    private static final String ADDRESS_1ST_LINE = "AddressLine1";
    private static final String ADDRESS_2ND_LINE = "AddressLine2";
    private static final String ADDRESS_3RD_LINE = "AddressLine3";
    private static final String ADDRESS_4TH_LINE = "AddressLine4";
    private static final String CITY = "City";
    private static final String STATE_PROVINCE = "StateProvince";
    private static final String ZIP_CODE = "ZipCode";
    private static final String RETURN_ADDRESS = "ReturnAddress";
    private static final String ORIGIN = "Origin";
    private static final String RETURN_TO_NAME = "ReturnToName";
    private static final String CARRIER_TRACKING_NUMBER = "CarrierTrackingNumber";
    private static final String SAHYOG_TRACKING_NUMBER = "SahyogTrackingNumber";
    private static final String DESTINATION = "Destination";
    public static final String SORT_CODE = "SortCode";
    private static final String MAILER_ID = "MailerID";
    private static final String SG_CODE = "SGCode";
    private static final String OPERATION_AREA = "OperationArea";
    private static final String SERVICE_TERRITORY = "ServiceTerritory";
    private static final String EXPECTED_DELIVERY = "ExpectedDelivery";
    private static final String LENGTH = "Length";
    private static final String WIDTH = "Width";
    private static final String HEIGHT = "Height";
    private static final String WEIGHT = "Weight";
    private static final String SHIP_DATE = "ShipDate";
    private static final String REFERENCE_1 = "Reference1";
    private static final String REFERENCE_2 = "Reference2";
    private static final String REFERENCE_3 = "Reference3";
    private static final String PHONE = "Phone";
    private static final String SORT_CODE_1 = "SortCode1";
    public static final String SORT_CODE_2 = "SortCode2";
    private static final String HTML_IMAGE_TAG_START = "data:$image/jpg;base64,";

    @Autowired
    private ApplicationProperties applicationProperties;

    /*private final BarcodeImageGenerator barcodeImageGenerator;
    private final BarcodeDataPreparer barcodeDataPreparer;
    private final TemplateService templateService;
    private final BarcodeRetrieverService barcodeRetrieverService;
    private final ReturnAddressService returnAddressService;
    private final OriginDependentSortCodeFetcherService originDependentSortCodeFetcherService;
    private final CarrierStrategyPicker carrierStrategyPicker;*/


    public Map<String, Object> prepareLabelData(LabelRequestDto labelRequest) {

        // Populate map with fields which will be included in template
        Map<String, Object> fields = new HashMap<>();

        fields.put(ID, UUID.randomUUID().toString());
        // parse data for return/origin address

        prepareReturnAddress(fields, labelRequest);

        prepareInternalSortData(fields, labelRequest.getIntSortCodes());

        prepareExternalSortData(fields, labelRequest);

        // Prepare data for destination
        prepareDestinationData(fields, labelRequest.getDestinationAddress());

        if (labelRequest.getEstimatedDeliveryDate() != null) {
            fields.put(EXPECTED_DELIVERY, labelRequest.getEstimatedDeliveryDate()
                    .atStartOfDay()
                    .format(expectedDeliveryDateFormatter)
                    .toUpperCase());
        }
        BigDecimal length = DimensionUtility.convertToIn(labelRequest.getLength(), labelRequest.getDimensionUom());
        fields.put(LENGTH, length);
        BigDecimal width = DimensionUtility.convertToIn(labelRequest.getWidth(), labelRequest.getDimensionUom());
        fields.put(WIDTH, width);
        BigDecimal height = DimensionUtility.convertToIn(labelRequest.getHeight(), labelRequest.getDimensionUom());
        fields.put(HEIGHT, height);
        BigDecimal weight = WeightUtility.convertToLb(labelRequest.getWeight(), labelRequest.getWeightUom());
        fields.put(WEIGHT, weight);
        String shipDateFormatted = labelRequest.getShipDate() != null ? labelRequest.getShipDate().format(shipDateFormatter) : "";
        if (labelRequest.getShipDate() != null) {
            fields.put(SHIP_DATE, shipDateFormatted);
        }
        labelRequest.getTrackingNumbers().stream()
                .filter(Objects::nonNull)
                .filter(trackingNumberDto -> StringUtils.equalsIgnoreCase("SAHYOG", trackingNumberDto.getType()))
                .findFirst()
                .ifPresent(trackingNumberDto -> fields.put(SAHYOG_TRACKING_NUMBER, trackingNumberDto.getValue()));
        fields.put(REFERENCE_1, labelRequest.getReference1());
        fields.put(REFERENCE_2, labelRequest.getReference2());
        fields.put(REFERENCE_3, labelRequest.getReference3());
        fields.put(PHONE, labelRequest.getDestinationAddress().getPhoneNo());

        /*String templateType = labelRequest.getLabelType() == LabelTypeEnum.ZPL ? ZPL_EXTENSION : HTML_EXTENSION;
        ApplicationProperties.TemplateMetadata templateMetaData = applicationProperties.getTemplateMetadata();

        // Some fields are specific just for one client. Take additional fields list and populate hash map with these data as well
        if (templateMetaData != null && MapUtils.isNotEmpty(templateMetaData.getTemplateMetadataConfigMap())) {
            List<String> additionalFieldList = templateMetaData.getTemplateMetadataConfigMap().get(labelRequest.getServiceCode().getValue());
            if (additionalFieldList != null) {
                Map<String, Object> additionalFields = prepareAdditionalFields(labelRequest, additionalFieldList, sahyogTrackingNumber, carrierTrackingNumber, estimatedDeliveryDate, originDependentExtSortCode, extSortCodes);
                fields.putAll(additionalFields);
            }
        }*/
        return fields;
    }


    private void prepareExternalSortData(Map<String, Object> fields, LabelRequestDto labelRequest) {
        if (labelRequest.getExtSortCodes() != null) {
            if (labelRequest.isUniversalCarrier()) {
                fields.put(SORT_CODE, labelRequest.getExtSortCodes().get(SORT_CODE_1));
                fields.put(SORT_CODE_2, labelRequest.getExtSortCodes().get(SORT_CODE_2));
            } else {
                fields.put(SERVICE_TERRITORY, labelRequest.getExtSortCodes().get(SERVICE_TERRITORY));
                fields.put(OPERATION_AREA, labelRequest.getExtSortCodes().get(OPERATION_AREA));
                fields.put(SORT_CODE, labelRequest.getExtSortCodes().get(SORT_CODE));
            }
        }
        if (labelRequest.getOriginExtSortCodeDto() != null) {
            fields.put(MAILER_ID, labelRequest.getOriginExtSortCodeDto().getMailerId());
            if (labelRequest.getOriginExtSortCodeDto().getSgCode() != null &&
                    !labelRequest.getOriginExtSortCodeDto().getSgCode().isEmpty()) {
                fields.put(SG_CODE, labelRequest.getOriginExtSortCodeDto().getSgCode());
            }
        }
    }

    private void prepareInternalSortData(Map<String, Object> fields, Map<String, String> intSortCodeMap) {
        if (intSortCodeMap != null) {
            for (String key : intSortCodeMap.keySet()) {
                fields.put(key, intSortCodeMap.get(key));
            }
        }
    }

    private void prepareReturnAddress(Map<String, Object> fields, LabelRequestDto labelRequestDto) {
        // Return Address
        if (null != labelRequestDto.getReturnAddress()) {
            Map<String, Object> returnAddressData = new HashMap<>();
            returnAddressData.put(NAME, labelRequestDto.getReturnAddress().getFirstName());
            returnAddressData.put(ADDRESS_1, labelRequestDto.getReturnAddress().getAddressLine1());
            returnAddressData.put(CITY, labelRequestDto.getReturnAddress().getCity());
            returnAddressData.put(STATE_PROVINCE, labelRequestDto.getReturnAddress().getState());
            returnAddressData.put(ZIP_CODE, labelRequestDto.getReturnAddress().getZipCode());
            fields.put(RETURN_ADDRESS, returnAddressData);
        }

        // Origin
        if (null != labelRequestDto.getOriginAddress()) {
            Map<String, Object> originData = new HashMap<>();
            originData.put(ADDRESS_1, labelRequestDto.getOriginAddress().getAddressLine1());
            originData.put(CITY, labelRequestDto.getOriginAddress().getCity());
            originData.put(STATE_PROVINCE, labelRequestDto.getOriginAddress().getState());
            originData.put(ZIP_CODE, labelRequestDto.getOriginAddress().getZipCode());
            originData.put(RETURN_TO_NAME, labelRequestDto.getOriginAddress().getFirstName());
            fields.put(ORIGIN, originData);
        }

    }

    private void prepareDestinationData(Map<String, Object> fields, AddressDto address) {
        // Destination
        Map<String, Object> destinationData = new HashMap<>();
        String firstName = address.getFirstName() != null ? address.getFirstName().toUpperCase() : "";
        String lastName = address.getLastName() != null ? address.getLastName().toUpperCase() : "";


        destinationData.put(NAME, firstName + " " + lastName);
        destinationData.put(ADDRESS_1, address.getAddressLine1() != null ? address.getAddressLine1().toUpperCase() : "");
        destinationData.put(ADDRESS_2, address.getAddressLine2() != null ? address.getAddressLine2().toUpperCase() : "");
        destinationData.put(CITY, address.getCity() != null ? address.getCity().toUpperCase() : "");
        destinationData.put(STATE_PROVINCE, address.getState() != null ? address.getState().toUpperCase() : "");
        destinationData.put(ZIP_CODE, address.getZipCode());

        destinationData.put(ADDRESS_1ST_LINE, address.getAddressLine2() != null && !address.getAddressLine2().isEmpty() ? firstName + " " + lastName : "");
        destinationData.put(ADDRESS_2ND_LINE, address.getAddressLine2() != null && !address.getAddressLine2().isEmpty() ? address.getAddressLine1().toUpperCase() : firstName + " " + lastName);
        destinationData.put(ADDRESS_3RD_LINE, address.getAddressLine2() != null && !address.getAddressLine2().isEmpty() ? address.getAddressLine2().toUpperCase() : address.getAddressLine1().toUpperCase());
        destinationData.put(ADDRESS_4TH_LINE, address.getCity() + ", " + address.getState() + " " + address.getZipCode());

        fields.put(DESTINATION, destinationData);
    }

    /*private Map<String, Object> prepareAdditionalFields(LabelRequest labelRequest, List<TemplateField> additionalFieldList) {
        Map<String, Object> additionalFields = new HashMap<>();

        // Call Data preparer class which will calculate some fields and prepare request if needed for some additional fields
        BarcodeImageRequest barcodeImageRequest = barcodeDataPreparer.calculateFieldsAndPrepareRequest(labelRequest, additionalFieldList);

        // If we have prepared some data to invoke service for barcode generation
        if (barcodeImageRequest.getData().size() > 0) {
            try {
                log.info("Sending request to barcode image generator for {}", barcodeImageRequest);
                BarcodeImageResponse barcodeImages = barcodeImageGenerator.getBarcodeImages(barcodeImageRequest);
                log.info("Received barcode images: {}", barcodeImages);
                // populate map with generated data
                prepareDataForBarcodes(barcodeImages, additionalFields);
            } catch (Exception e) {
                log.error("Unable to fetch images with tracking number {} from image generator: ", sahyogTrackingNumber, e);
                throw new UnableToFetchBarcodeImagesException("Error fetching barcode images");
            }
        }
        return additionalFields;
    }

    // Add base64 strings in map, generated by python script
    private void prepareDataForBarcodes(BarcodeImageResponse barcodeImages, Map<String, Object> additionalFields) {
        if (barcodeImages != null) {
            for (BarcodeResponseData barcodeResponseData : barcodeImages.getBarcodes()) {
                additionalFields.put(barcodeResponseData.getPlaceholder().getFieldName(), HTML_IMAGE_TAG_START + barcodeResponseData.getBarcodeData());
            }
        }
    }*/
}
