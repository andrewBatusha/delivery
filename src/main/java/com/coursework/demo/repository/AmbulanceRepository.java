package com.coursework.demo.repository;

import com.coursework.demo.entity.Ambulance;
import org.springframework.data.repository.CrudRepository;

public interface AmbulanceRepository extends CrudRepository<Ambulance, Long> {
}
