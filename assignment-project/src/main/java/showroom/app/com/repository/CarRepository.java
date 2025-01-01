package showroom.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import showroom.app.com.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
