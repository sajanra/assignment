package showroom.app.com.entity;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle{
	
	private boolean hasCarrier;
  
    public Bike() {
    	
    }

    public Bike(String brand, boolean hasCarrier) {
        super(brand);
        this.hasCarrier = hasCarrier;
    }
   
    public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }
    
}
