package showroom.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import showroom.app.com.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	
}
