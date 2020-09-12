package com.habibank.repo;

import java.util.List;

import com.habibank.model.Account;
import com.habibank.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//not sure should this be Repository
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
	Customer findByUserName(String userName);
	Customer findByPassword(String password);
	Customer findByUserNameAndPassword(String userName, String password);

//	@Query(value = "SELECT a FROM account a WHERE a.acctID in (SELECT ca.acctID FROM cust_acct ca WHERE ca.custID=:custID)")
//works in H2 @Query(value = "SELECT * FROM account WHERE acctID=(SELECT acctID from cust_acct WHERE custID=?1)", nativeQuery = true)
@Query(value = "SELECT * FROM account WHERE acctID=(SELECT acctID from cust_acct WHERE custID=?1)", nativeQuery = true)
	List<Account> getCustomerAccounts(@Param("custID") List<Account> custID);

	Boolean existsByEmail(String email);
	public Boolean existsByuserName(String userName);

	
}