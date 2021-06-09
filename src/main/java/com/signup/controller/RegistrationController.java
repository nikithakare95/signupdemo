package com.signup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.signup.DTO.RegisterDto;
import com.signup.DTO.RegistrationCoverter;
import com.signup.model.Register;
import com.signup.repository.RegistrationRepo;
import com.signup.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationRepo repo;

	@Autowired
	RegistrationCoverter converter;

	@Autowired
	RegistrationService service;

	@RequestMapping("/register")

	public ModelAndView RegisterPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.html");
		return mv;
	}

	@Validated
	@PostMapping(path = "/dto")
	public String save(@Valid RegisterDto dto, BindingResult br, @Valid Register register) {
		List<String> em = service.getEmailList();
		if (br.hasErrors()) {
			return "BAD REQUEST. Please provide valid data";
		} else {

			if (service.checkPasswordAndConfirmPassword(register)) {
				if (em.contains(dto.getEmail())) {
					return "User already registered. DUPLICATE EMAIL";
				}
				else {
					Register reg = converter.dtoToEntity(dto);
					reg = repo.save(reg);
				}
			} else {
				return "Invalid confirm password";
			}
			return "Registration Done Successfully";
		}
	}

	@GetMapping("/findAll")
	public List<RegisterDto> findAll() {
		List<Register> findAll = repo.findAll();
		return converter.entityToDto(findAll);
	}

	@GetMapping(path = "/getUserData")
	public List<Register> getUser(Register reg) {
		return repo.findAll();

	}

	@DeleteMapping(path = "/deleteByFirstName")
	public String deleteByFirstName(String firstName) {
		List<Register> names = service.getFirstNames(firstName);
		System.out.println(names);
		if (names.isEmpty()) {
			return "No name found";

		} else {
			repo.deleteAll(names);
			return "deleted";
		}
	}

	@Validated
	@RequestMapping(path = "/doRegister")
	public String addUserData(@Valid Register reg, BindingResult br) {
		List<String> em = service.getEmailList();

		if (br.hasErrors()) {
			return "BAD REQUEST. Please provide valid data";
		} else {

			if (em.contains(reg.getEmail())) {
				return "User already registered. DUPLICATE EMAIL";
			}

			else {
				repo.save(reg);
			}

		}

		return "Registration Done Successfully";
	}
}
