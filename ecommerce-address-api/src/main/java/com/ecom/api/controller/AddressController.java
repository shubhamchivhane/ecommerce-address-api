package com.ecom.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.model.Address;
import com.ecom.api.model.AddressDTO;
import com.ecom.api.repo.AddressRepository;
import com.ecom.api.repo.UserRepository;
import com.ecom.api.service.AddressService;

@RestController
//@RequestMapping("/accounts")
public class AddressController {
	
	static
	{
		System.out.println("controller ------");
	}

	Logger logger = LoggerFactory.getLogger("AddressController");

	AddressService addressService;
	
	@Autowired
	AddressRepository repo;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping("/address")
	@ResponseBody
	public Address createAddress(@RequestBody Address address) {
		logger.info("Address Saved :" + address.toString());
		Address AddressSaved = addressService.save(address);

		logger.info("Address Saved :" + AddressSaved.toString());
		return address;
	}

	@GetMapping("/address/{id}")
	public Address get(@PathVariable("id") Long id) {

		Optional<Address> AddressRetreived = addressService.getAddress(id);
		Address Address = AddressRetreived.get();
		List<AddressDTO> Adr=repo.getAddressById(id);
		System.out.println("Address :"+Adr);
		
		return Address;
	}

//	@GetMapping("solcommerce/pdp-service/Address/bypage")
//	Page<Address> getAddresssByPage(
//			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
//			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
//		return addressService.getAddressByPage(pageNumber, pageSize);
//	}

	@PutMapping("/address/{id}")
	@ResponseBody
	public Address updateAddress(@RequestBody Address address) {
		Address AddressUpdated = addressService.save(address);

		logger.info("Address updated :" + AddressUpdated.toString());
		return address;
	}

	/*---Delete a Address by id---*/
	@DeleteMapping("/Address/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		addressService.deleteAddress(id);
		return ResponseEntity.ok().body("Address has been deleted successfully.");
	}
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/address")
	public List<Address> getAllAddress()
	{
		System.out.println("This is Address++++++++++++++++");
		List<Address> catgories=addressService.getAllAddress();
	
		//userRepository
		
		return catgories;
	}
}
