package ai.sahyog.labelgenerationservice.controller;

import ai.sahyog.labelgenerationservice.controller.models.LabelRequest;
import ai.sahyog.labelgenerationservice.controller.models.LabelResponse;
import ai.sahyog.labelgenerationservice.mappers.IRequestMapper;
import ai.sahyog.labelgenerationservice.service.LabelService;
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

    @PostMapping
    public Mono<ResponseEntity<LabelResponse>> generateLabel(@RequestBody Mono<LabelRequest> labelRequest) {
        return labelRequest.map(requestMapper::mapRequest)
                .flatMap(labelService::generateLabel)
                .map(requestMapper::mapResponse)
                .map(this::buildResponse);
    }

    private ResponseEntity<LabelResponse> buildResponse(LabelResponse labelResponse) {
        return ResponseEntity.ok(labelResponse);
    }
}
