package com.learning.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {

	
	Boolean existsByEmailAndContactNumber(String email,BigInteger contactNumber);
	Boolean existsByEmail(String email);
	
}
