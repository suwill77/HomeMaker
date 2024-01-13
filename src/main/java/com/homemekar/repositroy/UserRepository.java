package com.homemekar.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homemekar.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{
	
	@Query("select u from UserDtls u where u.number = :number")
   public UserDtls findByNumber(@Param("number") String number);

	//public UserDtls getUserByUserName(String name);
	
	long countByRole(String role);

	
	
	
	@Query("select u from UserDtls u where u.role != :role")
	public List<UserDtls> findByRoles(String role); 
	
	
	
	

	
}

