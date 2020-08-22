package com.coursework.demo.mapper;

import com.coursework.demo.dto.PatientDTO;
import com.coursework.demo.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO convertToDto(Patient patient);

    Patient convertToEntity(PatientDTO patientDTO);

    List<PatientDTO> convertToDtoList(List<Patient> patients);

}