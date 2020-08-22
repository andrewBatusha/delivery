package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Diagnosis;
import com.coursework.demo.repository.DiagnosisRepository;
import com.coursework.demo.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public Diagnosis getById(Long id) {
        return diagnosisRepository.findById(id).get();
    }

    @Override
    public List<Diagnosis> getAll() {
        return (List<Diagnosis>) diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis update(Diagnosis object) {
        return diagnosisRepository.save(object);
    }

    @Override
    public Diagnosis save(Diagnosis object) {
        return diagnosisRepository.save(object);
    }

    @Override
    public Diagnosis delete(Diagnosis object) {
        diagnosisRepository.delete(object);
        return object;
    }
}
