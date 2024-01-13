package com.homemekar.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homemekar.entity.ConDtls;

public interface ContRepository  extends JpaRepository<ConDtls,Integer> {
	
	long countByStates(String states);

	List<ConDtls> findAllByStates(String string);

	ConDtls findById(long id);
}
