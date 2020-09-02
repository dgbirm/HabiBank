package com.habibank.services;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.habibank.model.Account;


public class AccountService implements IService<Account>  {

	@Override
	public Page<Account> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account FindById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account saveOrUpdate(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

    
    
}