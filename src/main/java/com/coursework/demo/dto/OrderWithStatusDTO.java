package com.coursework.demo.dto;

import com.coursework.demo.entity.Order;
import com.coursework.demo.entity.enums.CallStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderWithStatusDTO {
    Order orderDTO;
    CallStatus callStatus;
}
