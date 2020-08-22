package com.coursework.demo.controller;

import com.coursework.demo.dto.PatientDTO;
import com.coursework.demo.entity.Patient;
import com.coursework.demo.mapper.PatientMapper;
import com.coursework.demo.service.PatientService;
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
@Api(tags = "Patient API")
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get patient info by id")
    public ResponseEntity<PatientDTO> get(@PathVariable("id") long id){
        Patient patient = patientService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientMapper.convertToDto(patient));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all patients")
    public ResponseEntity<List<PatientDTO>> list() {
        return ResponseEntity.ok().body(patientMapper.convertToDtoList(patientService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new patient")
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.save(patientMapper.convertToEntity(patientDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(patientMapper.convertToDto(patient));
    }

    @PutMapping
    @ApiOperation(value = "Update existing patient by id")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.update(patientMapper.convertToEntity(patientDTO));
        return ResponseEntity.status(HttpStatus.OK).body(patientMapper.convertToDto(patient));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete patient by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Patient patient = patientService.getById(id);
        patientService.delete(patient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
