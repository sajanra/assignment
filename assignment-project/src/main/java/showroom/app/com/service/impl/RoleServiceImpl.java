package showroom.app.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import showroom.app.com.entity.Role;
import showroom.app.com.repository.RoleRepository;
import showroom.app.com.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

}
