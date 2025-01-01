package showroom.app.com.entity;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle{
	
	private int seatingCapacity;
    
    public Car() {
    	
    }

    public Car(String brand, int seatingCapacity) {
        super(brand);
        this.seatingCapacity = seatingCapacity;
    }
   
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
	    
}
