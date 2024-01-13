package com.homemekar.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homemekar.entity.ApnaDtls;

public interface ApnaRepository extends JpaRepository<ApnaDtls,Integer> {
	
	long countByStates(String states);

	List<ApnaDtls> findAllByStates(String string);

	ApnaDtls findById(long id);
	
	

}
