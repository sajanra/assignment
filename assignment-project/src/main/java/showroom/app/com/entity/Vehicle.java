package showroom.app.com.entity;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Vehicle {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String vehicleBrand;
   
    public Vehicle() {
    	
    }
    
    public Vehicle(String brand) {
    	vehicleBrand = brand;
    }
    
	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

}