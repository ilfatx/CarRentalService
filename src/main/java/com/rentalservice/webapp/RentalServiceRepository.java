package com.rentalservice.webapp;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rentalservice.webapp.data.*;

public interface RentalServiceRepository extends MongoRepository<RentalService, String> {
    public RentalService findByUserName(String userName);
    public RentalService findById(String id);
    public List<RentalService> findAll();
    public List<RentalService> findByCar(Car car);
    public void delete(RentalService deleted);
    public RentalService save(RentalService saved);
}

