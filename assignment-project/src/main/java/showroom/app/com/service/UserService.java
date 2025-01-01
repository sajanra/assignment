package showroom.app.com.service;

import showroom.app.com.entity.User;

public interface UserService {
	
	public User createUser(User user);
	
	public String encodePassword(String password);

}
