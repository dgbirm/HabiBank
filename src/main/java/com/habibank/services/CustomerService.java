package com.habibank.services;

import com.habibank.model.Customer;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements IService<Customer> {

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer FindById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer saveOrUpdate(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



    //private final
    
}