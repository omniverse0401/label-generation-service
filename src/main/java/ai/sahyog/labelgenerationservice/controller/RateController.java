package ai.sahyog.labelgenerationservice.controller;

import ai.sahyog.labelgenerationservice.controller.models.ShipmentRequest;
import ai.sahyog.labelgenerationservice.controller.models.ShipmentResponse;
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
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public Mono<ResponseEntity<ShipmentResponse>> calculateRate(@RequestBody Mono<ShipmentRequest> rateRequest) {
        return rateRequest
                .map(this::buildResponse)
                .onErrorResume(throwable -> Mono.just(ResponseEntity.internalServerError().build()));
    }

    private ResponseEntity<ShipmentResponse> buildResponse(ShipmentRequest request) {
        String response = """
                {
                    "shipment_id": "f3e00bf0-7baa-49ac-882a-b7528d7526e0",
                    "parcel": [
                        {
                            "parcel_id": "cfcbdbbb-9024-4c5b-8e04-9c21e7cda7b7",
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
