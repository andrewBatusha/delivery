package com.coursework.demo.dto;

import com.coursework.demo.entity.Patient;
import com.coursework.demo.entity.enums.DiagnosisStatus;
import lombok.Data;

@Data
public class DiagnosisDTO {
    private long id;

    private String name;

    private DiagnosisStatus diagnosisStatus;

    private Patient patient;
}
