package showroom.app.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import showroom.app.com.entity.Role;
import showroom.app.com.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/create-role")
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}
}
