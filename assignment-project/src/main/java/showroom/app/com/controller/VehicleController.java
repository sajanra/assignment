package showroom.app.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import showroom.app.com.entity.Bike;
import showroom.app.com.entity.Car;
import showroom.app.com.entity.Vehicle;
import showroom.app.com.exception.ResourceNotFoundException;
import showroom.app.com.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	/*
	 * This API is for creating car details
	 */
	@PostMapping("/creat-car")
	@PreAuthorize("hasAnyRole('Admin')")
	public Car createCar(@RequestBody Car car){
		return vehicleService.createCar(car);
	}
	
	/*
	 * This API is for creating bike details
	 */
	@PostMapping("/creat-bike")
	@PreAuthorize("hasAnyRole('Admin')")
	public Bike createBike(@RequestBody Bike bike){
		return vehicleService.createBike(bike);
	}
	
	/*
	 * This API is for displaying vehicles details
	 */
	@GetMapping("/get-vehicle-detail")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<Vehicle> getAllVehicle(){
		return vehicleService.getAllVehicles();
	}
	
	/*
	 * This API is for fetching car detail by specific Id
	 */
	@GetMapping("/get-car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
		return vehicleService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found"));
    }
	
	/*
	 * This API is for fetching bike detail by Id
	 */
    @GetMapping("/get-bike/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
    	 return vehicleService.getBikeById(id)
                 .map(ResponseEntity::ok)
                 .orElseThrow(() -> new ResourceNotFoundException("Bike not found"));
    }
    
    /*
	 * This API is for updating car details for particular Id
	 */
    @PutMapping("/update-car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return ResponseEntity.ok(vehicleService.updateCar(id, updatedCar));
    }
    
    /*
	 * This API is for updating bike details based on Id
	 */
    @PutMapping("/update-bike/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable Long id, @RequestBody Bike updatedBike) {
        return ResponseEntity.ok(vehicleService.updateBike(id, updatedBike));
    }
    
    /*
	 * This API is for deleting car details by Id
	 */
    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        vehicleService.deleteCar(id);
        return ResponseEntity.ok("Car deleted successfully");
    }
    
    /*
	 * This API is for deleting bike details by id
	 */
    @DeleteMapping("/delete-bike/{id}")
    public ResponseEntity<String> deleteBike(@PathVariable Long id) {
        vehicleService.deleteBike(id);
        return ResponseEntity.ok("Bike deleted successfully");
    }
}
