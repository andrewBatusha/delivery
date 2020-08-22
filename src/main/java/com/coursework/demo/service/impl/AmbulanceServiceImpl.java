package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Ambulance;
import com.coursework.demo.repository.AmbulanceRepository;
import com.coursework.demo.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository) {
        this.ambulanceRepository = ambulanceRepository;
    }

    @Override
    public Ambulance getById(Long id) {
        return ambulanceRepository.findById(id).get();
    }

    @Override
    public List<Ambulance> getAll() {
        return (List<Ambulance>) ambulanceRepository.findAll();
    }

    @Override
    public Ambulance update(Ambulance object) {
        return ambulanceRepository.save(object);
    }

    @Override
    public Ambulance save(Ambulance object) {
        return ambulanceRepository.save(object);
    }

    @Override
    public Ambulance delete(Ambulance object) {
        ambulanceRepository.delete(object);
        return object;
    }
}
