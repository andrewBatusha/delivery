package com.coursework.demo.dto;

import com.coursework.demo.entity.enums.Condition;
import lombok.Data;

@Data
public class PatientDTO {

    private long id;

    private String name;

    private String phoneNumber;

    private int age;

    private Condition condition;
}
