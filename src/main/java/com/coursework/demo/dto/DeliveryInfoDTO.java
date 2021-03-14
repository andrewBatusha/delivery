package com.coursework.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryInfoDTO {

    private String deliveryManName;

    private String deliveryManSurname;

    private String model;

    private String colour;
}
