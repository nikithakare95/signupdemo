package com.signup.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

import lombok.Data;

@Data

public class RegisterDto {
	
	private ObjectId _id;

	@NotNull(message = "First Name should not be null")
	@NotEmpty(message = "It should not be empty")
	@Size(max = 30, message = "FirstName should not exceed 30 characters")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only Characters are allowed")
	private String firstName;

	@NotNull(message = "Last Name should not be null")
	@NotEmpty(message = "It should not be empty")
	@Size(max = 30, message = "LastName should not exceed 30 characters")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only Characters are allowed")
	private String lastName;

	@NotBlank
	@Size(min = 0, max = 8)
	private String password;

	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@Size(min = 10, max = 10)
	@Pattern(regexp = "(^$|[0-9]{10})", message = "only digits are allowed")
	private String phoneNumber;
	

	@NotNull(message = "Address should not be null")
	@NotEmpty(message = "It should not be empty")
	@Size(max = 60, message = "Address should not exceed 60 characters")
	private String address;
	

	@NotNull(message = "city should not be null")
	@NotEmpty(message = "It should not be empty")
	@Size(max = 30, message = "City should not exceed 30 characters")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only Characters are allowed")
	private String city;


	@Pattern(regexp = "([0-9]{5}(?:-[0-9]{4})?$)", message = "Provide valid zip code")
	private String zip;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return String.format(
				"RegisterDto [firstName=%s, lastName=%s, password=%s, email=%s, phoneNumber=%s, address=%s, city=%s, zip=%s]",
				firstName, lastName, password, email, phoneNumber, address, city, zip);
	}

	

	
}
