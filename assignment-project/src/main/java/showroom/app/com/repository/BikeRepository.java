package showroom.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import showroom.app.com.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{

}
