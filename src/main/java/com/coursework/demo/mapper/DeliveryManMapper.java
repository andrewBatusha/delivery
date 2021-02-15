package com.coursework.demo.mapper;

import com.coursework.demo.dto.DeliveryManDTO;
import com.coursework.demo.entity.DeliveryMan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryManMapper {

    DeliveryManDTO convertToDto(DeliveryMan deliveryMan);

    DeliveryMan convertToEntity(DeliveryManDTO deliveryManDTO);

    List<DeliveryManDTO> convertToDtoList(List<DeliveryMan> deliveryManList);

}
