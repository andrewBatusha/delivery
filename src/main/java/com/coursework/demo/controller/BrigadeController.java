package com.coursework.demo.controller;

import com.coursework.demo.dto.BrigadeDTO;
import com.coursework.demo.entity.Brigade;
import com.coursework.demo.mapper.BrigadeMapper;
import com.coursework.demo.service.BrigadeService;
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
@Api(tags = "Brigade API")
@RequestMapping("/brigades")
public class BrigadeController {

    private final BrigadeService brigadeService;
    private final BrigadeMapper brigadeMapper;

    @Autowired
    public BrigadeController(BrigadeService brigadeService, BrigadeMapper brigadeMapper) {
        this.brigadeService = brigadeService;
        this.brigadeMapper = brigadeMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get brigade info by id")
    public ResponseEntity<BrigadeDTO> get(@PathVariable("id") long id){
        Brigade brigade = brigadeService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(brigadeMapper.convertToDto(brigade));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all brigades")
    public ResponseEntity<List<BrigadeDTO>> list() {
        return ResponseEntity.ok().body(brigadeMapper.convertToDtoList(brigadeService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new brigade")
    public ResponseEntity<BrigadeDTO> save(@RequestBody BrigadeDTO brigadeDTO) {
        Brigade brigade = brigadeService.save(brigadeMapper.convertToEntity(brigadeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(brigadeMapper.convertToDto(brigade));
    }

    @PutMapping
    @ApiOperation(value = "Update existing brigade by id")
    public ResponseEntity<BrigadeDTO> update(@RequestBody BrigadeDTO brigadeDTO) {
        Brigade brigade = brigadeService.update(brigadeMapper.convertToEntity(brigadeDTO));
        return ResponseEntity.status(HttpStatus.OK).body(brigadeMapper.convertToDto(brigade));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete brigade by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Brigade brigade = brigadeService.getById(id);
        brigadeService.delete(brigade);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
