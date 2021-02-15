package com.coursework.demo.dto;

import com.coursework.demo.entity.Client;
import com.coursework.demo.entity.DeliveryMan;
import com.coursework.demo.entity.enums.CallStatus;
import lombok.Data;

@Data
public class CallDTO {
    private long id;

    private String order;

    private DeliveryMan deliveryman;

    private Client client;

    private CallStatus callStatus;
}
