package com.coursework.demo.dto;

import lombok.Data;

@Data
public class BrigadeDTO {
    private long id;

    private String doctor;

    private String paramedic;

    private String nurse;
}
