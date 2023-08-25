package ai.sahyog.labelgenerationservice.mappers;

import ai.sahyog.labelgenerationservice.controller.models.LabelRequest;
import ai.sahyog.labelgenerationservice.controller.models.LabelResponse;
import ai.sahyog.labelgenerationservice.service.dto.LabelRequestDto;
import ai.sahyog.labelgenerationservice.service.dto.LabelResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRequestMapper {

    LabelRequestDto mapRequest(LabelRequest labelRequest);

    LabelResponse mapResponse(LabelResponseDto labelResponseDto);

}
