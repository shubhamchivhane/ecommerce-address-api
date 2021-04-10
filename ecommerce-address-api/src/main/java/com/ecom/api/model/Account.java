package com.ecom.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "ROLLINGSTONE_ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@OneToOne
	@JoinColumn(name = "USER_PROFILE_ID")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<Address> addresses = new HashSet<Address>();

}
