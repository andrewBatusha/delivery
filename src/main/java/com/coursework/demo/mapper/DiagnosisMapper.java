package com.coursework.demo.mapper;

import com.coursework.demo.dto.DiagnosisDTO;
import com.coursework.demo.entity.Diagnosis;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    DiagnosisDTO convertToDto(Diagnosis diagnosis);

    Diagnosis convertToEntity(DiagnosisDTO diagnosisDTO);

    List<DiagnosisDTO> convertToDtoList(List<Diagnosis> diagnoses);

}