package ai.sahyog.labelgenerationservice.service;

import ai.sahyog.labelgenerationservice.service.dto.LabelRequestDto;
import ai.sahyog.labelgenerationservice.service.dto.LabelResponseDto;
import reactor.core.publisher.Mono;

public interface LabelService {

    Mono<LabelResponseDto> generateLabel(LabelRequestDto labelRequestDto);
}
