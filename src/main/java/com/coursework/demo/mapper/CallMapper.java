package com.coursework.demo.mapper;

import com.coursework.demo.dto.CallDTO;
import com.coursework.demo.entity.Call;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CallMapper {

    CallDTO convertToDto(Call call);

    Call convertToEntity(CallDTO callDTO);

    List<CallDTO> convertToDtoList(List<Call> calls);

}
