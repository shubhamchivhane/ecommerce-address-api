package com.ecom.api.model;

import javax.persistence.CascadeType;
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
@Entity
@Table(name = "ROLLINGSTONE_ADDRESS")
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="house_number", nullable = false)
	private String houseNumber;
	
	@Column(name="street_address", nullable = false)
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	@Column(name="zip_code", nullable = false)
	private String zipCode;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name  = "ACCOUNT_ID", nullable = false)
	private Account account;
	
	
}
