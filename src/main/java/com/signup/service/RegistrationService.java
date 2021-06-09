package com.signup.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.signup.model.Register;
import com.signup.repository.RegistrationRepo;

@Service
public class RegistrationService {
	

	@Autowired
	RegistrationRepo repository;
	@Autowired
	MongoTemplate mongotemplate;
	

	public List<Register> getFirstNames(String firstName){
		List<Register> firstNamesList =repository.findByfirstName(firstName);
		return firstNamesList;
	}

	public List<Register> getLastNames(String lastName){
		List<Register> lastNamesList=repository.findByfirstName(lastName);
		return lastNamesList;
	}
	
	public List<String> getEmailList() {

		List<String> emails = mongotemplate.findAll(Register.class).stream().map(Register::getEmail)
				.filter(Objects::nonNull).distinct().collect(Collectors.toList());

		System.out.println(emails);

		return emails;
	}
	
	public boolean checkPasswordAndConfirmPassword(Register reg) {
		return reg.getPassword().equals(reg.getConfirmPassword());
		
	}

}

