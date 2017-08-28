package com.rentalservice.webapp;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rentalservice.webapp.data.*;

public interface CarRepository extends MongoRepository<Car, String> {
    public Car findByReg(String reg);
    public List<Car> findAll();
    public void delete(Car deleted);
    public Car save(Car saved);
}
