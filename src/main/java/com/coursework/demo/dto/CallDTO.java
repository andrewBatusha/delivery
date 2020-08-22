package com.coursework.demo.dto;

import com.coursework.demo.entity.Brigade;
import com.coursework.demo.entity.Patient;
import com.coursework.demo.entity.enums.CallStatus;
import lombok.Data;

@Data
public class CallDTO {
    private long id;

    private String description;

    private String address;

    private Brigade brigade;

    private Patient patient;

    private CallStatus callStatus;
}
