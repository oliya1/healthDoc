package com.nicico.healthDoc.mapper;
import com.nicico.healthDoc.dto.request.DocLocationUpdateDto;
import com.nicico.healthDoc.entity.DocLocationHistory;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DocLocationHistoryMapper {
    void updateDocLocationFromDto(DocLocationUpdateDto dto, @MappingTarget DocLocationHistory entity);
}
