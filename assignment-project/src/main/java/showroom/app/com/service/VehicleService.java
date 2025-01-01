package showroom.app.com.service;

import java.util.List;
import java.util.Optional;

import showroom.app.com.entity.Bike;
import showroom.app.com.entity.Car;
import showroom.app.com.entity.Vehicle;

public interface VehicleService {
	
	public Car createCar(Car car);
	
	public Bike createBike(Bike bike); 
    
	public List<Vehicle> getAllVehicles();
    
	public Optional<Car> getCarById(Long id);

	public Optional<Bike> getBikeById(Long id);
	
	public void deleteCar(Long id);

    public void deleteBike(Long id);
	
    public Optional<Vehicle> getVehicleById(Integer vehicleId);

    public Car updateCar(Long id, Car updatedCar);
    
    public Bike updateBike(Long id, Bike updatedBike);
}
