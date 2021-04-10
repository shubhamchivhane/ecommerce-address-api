package com.ecom.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
public class AddressDTO {

	

	private long id;
	
	private String houseNumber;
	

	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private String zipCode;

	private Account account;
	
	
}
