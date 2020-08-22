package com.coursework.demo.mapper;

import com.coursework.demo.dto.BrigadeDTO;
import com.coursework.demo.entity.Brigade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrigadeMapper {

    BrigadeDTO convertToDto(Brigade brigade);

    Brigade convertToEntity(BrigadeDTO brigadeDTO);

    List<BrigadeDTO> convertToDtoList(List<Brigade> licens);

}
