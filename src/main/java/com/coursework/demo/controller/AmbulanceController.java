package com.coursework.demo.controller;

import com.coursework.demo.dto.AmbulanceDTO;
import com.coursework.demo.entity.Ambulance;
import com.coursework.demo.mapper.AmbulanceMapper;
import com.coursework.demo.service.AmbulanceService;
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
@Api(tags = "Ambulance API")
@RequestMapping("/ambulances")
public class AmbulanceController {

    private final AmbulanceService ambulanceService;
    private final AmbulanceMapper ambulanceMapper;

    @Autowired
    public AmbulanceController(AmbulanceService ambulanceService, AmbulanceMapper ambulanceMapper) {
        this.ambulanceService = ambulanceService;
        this.ambulanceMapper = ambulanceMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get ambulance info by id")
    public ResponseEntity<AmbulanceDTO> get(@PathVariable("id") long id){
        Ambulance ambulance = ambulanceService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ambulanceMapper.convertToDto(ambulance));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all ambulances")
    public ResponseEntity<List<AmbulanceDTO>> list() {
        return ResponseEntity.ok().body(ambulanceMapper.convertToDtoList(ambulanceService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new ambulance")
    public ResponseEntity<AmbulanceDTO> save(@RequestBody AmbulanceDTO passportDTO) {
        Ambulance ambulance = ambulanceService.save(ambulanceMapper.convertToEntity(passportDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(ambulanceMapper.convertToDto(ambulance));
    }

    @PutMapping
    @ApiOperation(value = "Update existing ambulance by id")
    public ResponseEntity<AmbulanceDTO> update(@RequestBody AmbulanceDTO ambulanceDTO) {
        Ambulance ambulance = ambulanceService.update(ambulanceMapper.convertToEntity(ambulanceDTO));
        return ResponseEntity.status(HttpStatus.OK).body(ambulanceMapper.convertToDto(ambulance));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete ambulance by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Ambulance ambulance = ambulanceService.getById(id);
        ambulanceService.delete(ambulance);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
