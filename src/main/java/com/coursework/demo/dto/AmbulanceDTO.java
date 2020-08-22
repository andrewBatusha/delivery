package com.coursework.demo.dto;

import com.coursework.demo.entity.Brigade;
import com.coursework.demo.entity.enums.AmbulanceStatus;
import lombok.Data;

@Data
public class AmbulanceDTO {
    private long id;

    private String driver;

    private Brigade brigade;

    private AmbulanceStatus ambulanceStatus;

}
