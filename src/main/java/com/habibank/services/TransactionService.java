package com.habibank.services;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.habibank.model.Transaction;
import com.habibank.services.IService;

public class TransactionService implements IService<Transaction> {

	@Override
	public Page<Transaction> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction FindById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction saveOrUpdate(Transaction t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


    
}