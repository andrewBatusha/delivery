package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Brigade;
import com.coursework.demo.repository.BrigadeRepository;
import com.coursework.demo.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BrigadeServiceImpl implements BrigadeService {

    BrigadeRepository brigadeRepository;

    @Autowired
    public BrigadeServiceImpl(BrigadeRepository brigadeRepository) {
        this.brigadeRepository = brigadeRepository;
    }

    @Override
    public Brigade getById(Long id) {
        return brigadeRepository.findById(id).get();
    }

    @Override
    public List<Brigade> getAll() {
        return (List<Brigade>) brigadeRepository.findAll();
    }

    @Override
    public Brigade update(Brigade object) {
        return brigadeRepository.save(object);
    }

    @Override
    public Brigade save(Brigade object) {
        return brigadeRepository.save(object);
    }

    @Override
    public Brigade delete(Brigade object) {
        brigadeRepository.delete(object);
        return object;
    }
}
