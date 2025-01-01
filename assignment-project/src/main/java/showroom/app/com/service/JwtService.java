package showroom.app.com.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import showroom.app.com.entity.JwtRequest;
import showroom.app.com.entity.JwtResponse;
import showroom.app.com.entity.User;
import showroom.app.com.repository.UserRepository;
import showroom.app.com.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		String userName = jwtRequest.getUserName();
		String password = jwtRequest.getPassword();
		if(userName!=null && password!=null) {
			authenticate(userName, password);
			final UserDetails userDetails = loadUserByUsername(userName);
			String newGeneratedToken = jwtUtil.generateToken(userDetails);
			User user = userRepository.findById(userName).get();
			System.out.println("token : "+newGeneratedToken);
			return new JwtResponse(user, newGeneratedToken);
		}else {
			System.out.println("Username or password is null : username : "+userName+"  password : "+password);
			return null;
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   User user = userRepository.findById(username).get();
		   
		   if(user!=null) {
			   
			   return new org.springframework.security.core.userdetails.User(
					   user.getUserName(),
					   user.getUserPassword(),
					   getAuthorities(user)
					   );
			   
		   }else {
			   throw new UsernameNotFoundException("user name is not valid");
		   }
	}
		
	private Set getAuthorities(User user) {
		Set authorities = new HashSet<>();
		
		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		});
		
		return authorities;
	}
	
	private void authenticate(String userName,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		}catch (DisabledException e) {
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Bad credentials");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
