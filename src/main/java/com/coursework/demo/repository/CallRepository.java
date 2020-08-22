package com.coursework.demo.repository;

import com.coursework.demo.entity.Call;
import org.springframework.data.repository.CrudRepository;

public interface CallRepository extends CrudRepository<Call, Long> {
}
