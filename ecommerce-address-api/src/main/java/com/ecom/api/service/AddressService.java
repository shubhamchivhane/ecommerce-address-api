package com.ecom.api.service;

import java.util.List;
import java.util.Optional;

import com.ecom.api.model.Address;

public interface AddressService {

	public Address save(Address address) ;
	
	public Optional<Address> getAddress(Long addressId);
	
	public List<Address> getAllAddress();
	
	public void deleteAddress(Long addressId);
	
	
}
