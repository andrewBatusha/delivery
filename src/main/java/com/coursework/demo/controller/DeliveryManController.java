package com.coursework.demo.controller;

import com.coursework.demo.dto.DeliveryManDTO;
import com.coursework.demo.entity.DeliveryMan;
import com.coursework.demo.mapper.DeliveryManMapper;
import com.coursework.demo.service.DeliveryManService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@Api(tags = "DeliveryMan API")
@RequestMapping("/v1/deliverymen")
public class DeliveryManController {

    private final DeliveryManService deliveryManService;
    private final DeliveryManMapper deliveryManMapper;

    @Autowired
    public DeliveryManController(DeliveryManService deliveryManService, DeliveryManMapper deliveryManMapper) {
        this.deliveryManService = deliveryManService;
        this.deliveryManMapper = deliveryManMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get deliveryman info by id")
    public ResponseEntity<DeliveryManDTO> get(@PathVariable("id") long id) {
        DeliveryMan deliveryMan = deliveryManService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deliveryManMapper.convertToDto(deliveryMan));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all deliverymen")
    public ResponseEntity<List<DeliveryManDTO>> getList(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok().body(deliveryManMapper.convertToDtoList(deliveryManService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new deliveryman")
    public ResponseEntity<DeliveryManDTO> save(@RequestBody DeliveryManDTO deliveryManDTO) {
        DeliveryMan deliveryMan = deliveryManService.save(deliveryManMapper.convertToEntity(deliveryManDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryManMapper.convertToDto(deliveryMan));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing deliveryman by id")
    public ResponseEntity<DeliveryManDTO> update(@PathVariable("id") long id, @RequestBody DeliveryManDTO deliveryManDTO) {
        if (id == deliveryManDTO.getId()) {
            DeliveryMan deliveryMan = deliveryManService.update(deliveryManMapper.convertToEntity(deliveryManDTO));
            return ResponseEntity.status(HttpStatus.OK).body(deliveryManMapper.convertToDto(deliveryMan));
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete deliveryman by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        DeliveryMan deliveryMan = deliveryManService.getById(id);
        deliveryManService.delete(deliveryMan);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
