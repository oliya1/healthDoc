package com.nicico.healthDoc.mapper;
import com.nicico.healthDoc.dto.request.DocLocationUpdateDto;
import com.nicico.healthDoc.entity.DocLocationHistory;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DocLocationHistoryMapper {
    DocLocationHistory updateDocLocationFromDto(DocLocationUpdateDto dto, @MappingTarget DocLocationHistory entity);
}
