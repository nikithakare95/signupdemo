package com.signup.DTO;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.signup.model.Register;

@Component
public class RegistrationCoverter {


	@Validated
	public RegisterDto entityToDto(@Valid Register register) {
		
		ModelMapper mapper = new ModelMapper();
		RegisterDto map = mapper.map(register, RegisterDto.class);
		return map;
	}


	public List<RegisterDto> entityToDto(List<Register> register) {

		return register.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	@Validated
	public Register dtoToEntity(RegisterDto dto) {

		ModelMapper mapper = new ModelMapper();
		Register map = mapper.map(dto, Register.class);
		return map;
	}

	public List<Register> dtoToEntity(List<RegisterDto> dto) {

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}