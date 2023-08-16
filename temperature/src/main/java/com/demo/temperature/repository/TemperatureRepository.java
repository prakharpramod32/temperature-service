package com.demo.temperature.repository;

import com.demo.temperature.model.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, String> {
    Optional<Temperature> findByResourceId(String resourceId);
}
