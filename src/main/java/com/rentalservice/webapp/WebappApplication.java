package com.rentalservice.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.rentalservice.webapp.data.*;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

	@Autowired
	private RentalServiceRepository repositoryRentalService;
	@Autowired
	private CarBrandRepository repositoryCarBrand;
	@Autowired
	private CarRepository repositoryCar;
	@Autowired
	private RentalPointRepository repositoryRentalPoint;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repositoryRentalPoint.deleteAll();

		repositoryRentalPoint.save(new RentalPoint("city", "City Moscow Kremlin"));
		repositoryRentalPoint.save(new RentalPoint("road", "Road Hotel California"));

		System.out.println("RentalPoint found with findAll():");
		System.out.println("-------------------------------");
		for (RentalPoint rp : repositoryRentalPoint.findAll()) {
			System.out.println(rp);
		}
		System.out.println();

		System.out.println("RentalPoint found with findByShortName('road'):");
		System.out.println("--------------------------------");
		System.out.println(repositoryRentalPoint.findByShortName("road"));

		repositoryCarBrand.deleteAll();

		repositoryCarBrand.save(new CarBrand("audi", "Audi",CarType.Auto));
		repositoryCarBrand.save(new CarBrand("bmw", "BMW",CarType.Motorcycle));

		System.out.println("CarBrand found with findAll():");
		System.out.println("-------------------------------");
		for (CarBrand rp : repositoryCarBrand.findAll()) {
			System.out.println(rp);
		}
		System.out.println();

		System.out.println("Car found with findByShortName('bmw'):");
		System.out.println("--------------------------------");
		System.out.println(repositoryCarBrand.findByShortName("bmw"));

		repositoryCar.deleteAll();

		repositoryCar.save(new Car("a123aa102", repositoryCarBrand.findByShortName("audi")));
		repositoryCar.save(new Car("b345bb77", repositoryCarBrand.findByShortName("bmw")));

		System.out.println("CarBrand found with findAll():");
		System.out.println("-------------------------------");
		for (Car rp : repositoryCar.findAll()) {
			System.out.println(rp);
		}
		System.out.println();

		System.out.println("CarBrand found with findByReg('a123aa102'):");
		System.out.println("--------------------------------");
		System.out.println(repositoryCar.findByReg("a123aa102"));

		repositoryRentalService.deleteAll();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 3);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		cal2.add(Calendar.HOUR_OF_DAY, 6);
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(new Date());
		cal3.add(Calendar.HOUR_OF_DAY, 20);

		repositoryRentalService.save(new RentalService(repositoryCar.findByReg("a123aa102"),repositoryRentalPoint.findByShortName("road"),repositoryRentalPoint.findByShortName("road"),
				new Date(), cal.getTime(), "Putin Vladimir Vladimirovich"));
		repositoryRentalService.save(new RentalService(repositoryCar.findByReg("a123aa102"),repositoryRentalPoint.findByShortName("road"),repositoryRentalPoint.findByShortName("city"),
				cal2.getTime(), cal3.getTime(),  "Barak Obama"));

		System.out.println("RentalService found with findAll():");
		System.out.println("-------------------------------");
		for (RentalService rp : repositoryRentalService.findAll()) {
			System.out.println(rp);
		}
		System.out.println();

		System.out.println("RentalService found with findByCar('road'):");
		System.out.println("--------------------------------");
		for (RentalService rp : repositoryRentalService.findByCar(repositoryCar.findByReg("a123aa102"))) {
			System.out.println(rp);
		}
	}
}
