package com.coursework.demo.repository;

import com.coursework.demo.entity.DeliveryMan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeliveryManRepository extends PagingAndSortingRepository<DeliveryMan, Long> {
}
