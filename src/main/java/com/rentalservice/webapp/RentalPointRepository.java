package com.rentalservice.webapp;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rentalservice.webapp.data.*;

public interface RentalPointRepository extends MongoRepository<RentalPoint, String> {
    public RentalPoint findByShortName(String shortName);
    public List<RentalPoint> findAll();
    public void delete(RentalPoint deleted);
    public RentalPoint save(RentalPoint saved);
}

