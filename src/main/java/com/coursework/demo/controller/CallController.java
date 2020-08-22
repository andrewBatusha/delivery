package com.coursework.demo.controller;

import com.coursework.demo.dto.CallDTO;
import com.coursework.demo.entity.Call;
import com.coursework.demo.mapper.CallMapper;
import com.coursework.demo.service.CallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Call API")
@RequestMapping("/calls")
public class CallController {

    private final CallService callService;
    private final CallMapper callMapper;

    @Autowired
    public CallController(CallService callService, CallMapper callMapper) {
        this.callService = callService;
        this.callMapper = callMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get call info by id")
    public ResponseEntity<CallDTO> get(@PathVariable("id") long id){
        Call call = callService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(callMapper.convertToDto(call));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all calls")
    public ResponseEntity<List<CallDTO>> list() {
        return ResponseEntity.ok().body(callMapper.convertToDtoList(callService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new call")
    public ResponseEntity<CallDTO> save(@RequestBody CallDTO callDTO) {
        Call call = callService.save(callMapper.convertToEntity(callDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(callMapper.convertToDto(call));
    }

    @PutMapping
    @ApiOperation(value = "Update existing call by id")
    public ResponseEntity<CallDTO> update(@RequestBody CallDTO callDTO) {
        Call call = callService.update(callMapper.convertToEntity(callDTO));
        return ResponseEntity.status(HttpStatus.OK).body(callMapper.convertToDto(call));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete call by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Call call = callService.getById(id);
        callService.delete(call);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
