package ai.sahyog.labelgenerationservice.controller;

import ai.sahyog.labelgenerationservice.controller.models.LabelRequest;
import ai.sahyog.labelgenerationservice.controller.models.LabelResponse;
import ai.sahyog.labelgenerationservice.controller.models.ShipmentRequest;
import ai.sahyog.labelgenerationservice.controller.models.ShipmentResponse;
import ai.sahyog.labelgenerationservice.mappers.IRequestMapper;
import ai.sahyog.labelgenerationservice.service.LabelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/label")
public class LabelGenerationController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private IRequestMapper requestMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public Mono<ResponseEntity<ShipmentResponse>> generateLabel(@RequestBody Mono<ShipmentRequest> labelRequest) {
        /*return labelRequest.map(requestMapper::mapRequest)
                .flatMap(labelService::generateLabel)
                .map(requestMapper::mapResponse)
                .map(this::buildResponse);*/
        return labelRequest.map(this::buildResponse);
    }

    private ResponseEntity<ShipmentResponse> buildResponse(ShipmentRequest request) {
        String response = """
                {
                    "shipment_id": "f3e00bf0-7baa-49ac-882a-b7528d7526e0",
                    "parcel": [
                        {
                            "parcel_id": "cfcbdbbb-9024-4c5b-8e04-9c21e7cda7b7",
                            "printing_options": {
                              "label_format": "ZPL",
                              "label_type": "SHIPMENT_LABEL"
                            },
                            "label_data": "^XA^CI28^CF0,40^FO50,70^FDRETURN TO:^FS^CF0,30^FO80,130^FDLevis Inc.^FS^FO80,170^FD148 TROUTMAN ST^FS^FO80,210^FDBROOKLYN, NY 11206^FS^CF0,60^FO480,240^FDONT_NYC^FS^CF0,60^FO480,330^FDSON_MIA^FS^CF0,40^FO50,310^FDSHIP TO:^FS^CF0,30^FO80,370^FDSara Lee^FS^FO80,410^FD12204 SW 27TH ST^FS^FO80,450^FDMiami, FL, 33175^FS^FO20,550^GB770,6,5^FS^BY2,3,100^FO70,600^BCN, 100, Y, N, N, A^FDSH529012345678901234^FS^CF0,60^FO400,630^FB380,2,0,R^FH^FS^CFF,30^FO550,600^FDSahyog Inc^FS^FO550,650^FDSTANDARD^FS^FO70,800^B7N,11,5,16^FDSH529012345678901234|12204 SW 27TH ST|Miami|FL|33175|3.5LBS|5W|4H|12L|IN|STANDARD|2023-07-26^FS^FO20,1000^GB770,6,5^FS^XZ",
                            "zone": "2",
                            "rate": [
                                {
                                    "service_code": "STANDARD",
                                    "estimated_delivery_date": "2023-09-13",
                                    "dim_weight": 2,
                                    "billed_weight": 2,
                                    "total_price": {
                                        "gross_amount": 6.75,
                                        "currency": "USD"
                                    },
                                    "price_list": [
                                        {
                                            "amount": 5.75,
                                            "currency": "USD",
                                            "type": "BASE_PRICE"
                                        },
                                        {
                                            "amount": 1.00,
                                            "currency": "USD",
                                            "type": "FUEL_SURCHARGE"
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }""";
        ShipmentResponse rateResponse = null;
        try {
            rateResponse = objectMapper.readValue(response, ShipmentResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(rateResponse);
    }
}
