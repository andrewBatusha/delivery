package com.coursework.demo.mapper;

import com.coursework.demo.dto.AmbulanceDTO;
import com.coursework.demo.entity.Ambulance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AmbulanceMapper {

    AmbulanceDTO convertToDto(Ambulance ambulance);

    Ambulance convertToEntity(AmbulanceDTO ambulanceDTO);

    List<AmbulanceDTO> convertToDtoList(List<Ambulance> ambulances);

}
