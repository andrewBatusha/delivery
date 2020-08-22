package com.coursework.demo.repository;

import com.coursework.demo.entity.Diagnosis;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {
}
