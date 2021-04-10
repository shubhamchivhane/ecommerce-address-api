package com.ecom.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.model.Address;
import com.ecom.api.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	final static org.slf4j.Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	AddressRepository repo;

	@Override
	public Address save(Address Address) {
//		if (Address.getAddressName() == null) {
//			logger.info("Addressname is null ");
//			throw new Http404Exception("Bad Request as Product category can not be null");
//		} else {
//			logger.info("Addressname is not null Addressname {} :" + Address.getAddressName());
//
//			Integer AddressCount = repo.countByAddressName(Address.getAddressName());
//			if (AddressCount != 0) {
//				throw new AddressNameAlreadyExistException("Addressname already exist with {} :" + Address.getAddressName());
//			}
//		}
		return repo.save(Address);
	}

	@Override
	public Optional<Address> getAddress(Long AddressId) {
		logger.info("service method getAddress :" + AddressId);
		Optional<Address> opt = repo.findById(AddressId);
//		if (!opt.isPresent()) {
//			throw new AddressNotFoundException("Address not found with id {} " + AddressId);
//		}
		return Optional.of(opt.get());
	}

	@Override
	public void deleteAddress(Long AddressId) {
		repo.deleteById(AddressId);
	}

	@Override
	public List<Address> getAllAddress() {

		return repo.findAll();
	}

}
