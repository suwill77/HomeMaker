package com.homemekar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.homemekar.entity.UserDtls;
import com.homemekar.repositroy.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	UserDtls user =	userRepo.findByNumber(username);
	
	if(user==null) {
		throw new UsernameNotFoundException("user not available !!");
	}
	 CustomUserDetails customUserDetails = new CustomUserDetails(user);
	 
	 return customUserDetails;
		
	}
	

}
