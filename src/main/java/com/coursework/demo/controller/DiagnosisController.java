package com.coursework.demo.controller;

import com.coursework.demo.dto.DiagnosisDTO;
import com.coursework.demo.entity.Diagnosis;
import com.coursework.demo.mapper.DiagnosisMapper;
import com.coursework.demo.service.DiagnosisService;
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
@Api(tags = "Diagnosis API")
@RequestMapping("/diagnoses")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    private final DiagnosisMapper diagnosisMapper;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService, DiagnosisMapper diagnosisMapper) {
        this.diagnosisService = diagnosisService;
        this.diagnosisMapper = diagnosisMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get diagnosis info by id")
    public ResponseEntity<DiagnosisDTO> get(@PathVariable("id") long id){
        Diagnosis diagnosis = diagnosisService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(diagnosisMapper.convertToDto(diagnosis));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all diagnoses")
    public ResponseEntity<List<DiagnosisDTO>> list() {
        return ResponseEntity.ok().body(diagnosisMapper.convertToDtoList(diagnosisService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new diagnosis")
    public ResponseEntity<DiagnosisDTO> save(@RequestBody DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = diagnosisService.save(diagnosisMapper.convertToEntity(diagnosisDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosisMapper.convertToDto(diagnosis));

    }

    @PutMapping
    @ApiOperation(value = "Update existing diagnosis by id")
    public ResponseEntity<DiagnosisDTO> update(@RequestBody DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = diagnosisService.update(diagnosisMapper.convertToEntity(diagnosisDTO));
        return ResponseEntity.status(HttpStatus.OK).body(diagnosisMapper.convertToDto(diagnosis));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete diagnosis by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Diagnosis diagnosis = diagnosisService.getById(id);
        diagnosisService.delete(diagnosis);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
