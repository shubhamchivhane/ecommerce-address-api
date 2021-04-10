package com.ecom.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.api.model.Address;
import com.ecom.api.model.AddressDTO;


@Repository
public interface AddressRepository  extends JpaRepository<Address, Long>{

	//Integer countByuserName(String name);
	
	@Query("select ad.id , ad.houseNumber, ad.streetAddress, ad.city,ad.state, ad.zipCode, ad.account.id from Address ad where id= :id")
	List<AddressDTO> getAddressById(Long id);
	
}
