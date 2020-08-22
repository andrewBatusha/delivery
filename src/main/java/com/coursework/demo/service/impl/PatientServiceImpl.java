package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Patient;
import com.coursework.demo.repository.PatientRepository;
import com.coursework.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> getAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Patient update(Patient object) {
        return patientRepository.save(object);
    }

    @Override
    public Patient save(Patient object) {
        return patientRepository.save(object);
    }

    @Override
    public Patient delete(Patient object) {
        patientRepository.delete(object);
        return object;
    }
}
