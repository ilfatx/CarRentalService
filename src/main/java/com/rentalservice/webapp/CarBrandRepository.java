package com.rentalservice.webapp;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rentalservice.webapp.data.*;

public interface CarBrandRepository extends MongoRepository<CarBrand, String> {
    public CarBrand findByShortName(String shortName);
    public List<CarBrand> findAll();
    public void delete(CarBrand deleted);
    public CarBrand save(CarBrand saved);
}
