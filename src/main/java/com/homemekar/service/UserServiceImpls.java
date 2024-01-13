 package com.homemekar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.homemekar.entity.UserDtls;
import com.homemekar.repositroy.UserRepository;

@Service
public class UserServiceImpls implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public UserDtls createData(UserDtls user) {
		// TODO Auto-generated method stub
		
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_ADMIN");
		
		return userRepo.save(user);
	}
	@Override
	public UserDtls createData1(UserDtls user) {
		// TODO Auto-generated method stub
		
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		
		user.setRole("ROLE_APNAGHAR");
		return userRepo.save(user);
	}
	@Override
	public UserDtls createData2(UserDtls user) {
		// TODO Auto-generated method stub
		
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		
		user.setRole("ROLE_CONTRACTOR");
		return userRepo.save(user);
	}

	 
	

}
