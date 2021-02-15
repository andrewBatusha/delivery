package com.coursework.demo.dto;

import com.coursework.demo.entity.enums.PaymentOption;
import lombok.Data;

@Data
public class OrderDTO {
    private long id;

    private String name;

    private Long price;

    private Long bonus;

    PaymentOption paymentOption;
}
