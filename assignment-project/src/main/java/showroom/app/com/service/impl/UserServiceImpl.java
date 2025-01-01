package showroom.app.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import showroom.app.com.entity.User;
import showroom.app.com.repository.UserRepository;
import showroom.app.com.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createUser(User user) {
		user.setUserPassword(encodePassword(user.getUserPassword()));
		return userRepository.save(user);
	}
	
	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	

}
