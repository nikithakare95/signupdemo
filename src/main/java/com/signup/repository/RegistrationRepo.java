package com.signup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.signup.model.Register;

@Repository
public interface RegistrationRepo extends MongoRepository<Register, String> {
	 List<Register> findByfirstName(String firstName);
	 List<Register> findBylastName(String lastName);

}
