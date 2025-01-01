package showroom.app.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import showroom.app.com.entity.Bike;
import showroom.app.com.entity.Car;
import showroom.app.com.entity.Vehicle;
import showroom.app.com.repository.BikeRepository;
import showroom.app.com.repository.CarRepository;
import showroom.app.com.repository.VehicleRepository;
import showroom.app.com.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private BikeRepository bikeRepository;


	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		return vehicleList;
	}

	@Override
	public Optional<Vehicle> getVehicleById(Integer vehicleId) {
		return vehicleRepository.findById(vehicleId);
	}

	public Bike createBike(Bike bike) {
		return bikeRepository.save(bike);
	}

	@Override
	public Optional<Car> getCarById(Long id) {
		return carRepository.findById(id);
	}

	@Override
	public Optional<Bike> getBikeById(Long id) {
		return bikeRepository.findById(id);
	}

	public Car createCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

	@Override
	public void deleteBike(Long id) {
		bikeRepository.deleteById(id);
	}
	
	public Car updateCar(Long id, Car updatedCar) {
        return carRepository.findById(id).map(car -> {
            car.setVehicleBrand(updatedCar.getVehicleBrand());
            car.setSeatingCapacity(updatedCar.getSeatingCapacity());
            return carRepository.save(car);
        }).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Bike updateBike(Long id, Bike updatedBike) {
        return bikeRepository.findById(id).map(bike -> {
            bike.setVehicleBrand(updatedBike.getVehicleBrand());
            bike.setHasCarrier(updatedBike.isHasCarrier());
            return bikeRepository.save(bike);
        }).orElseThrow(() -> new RuntimeException("Bike not found"));
    }

}
