package com.habibank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.habibank.model.Account;
import com.habibank.model.AccountType;
import com.habibank.model.Customer;
import com.habibank.model.Transaction;
import com.habibank.repo.AccountRepository;
import com.habibank.repo.CustomerRepository;
import com.habibank.repo.TransactionRepository;

//for having mock data to test.
@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
    private CustomerRepository custRepo;
    @Autowired
    private AccountRepository acctRepo;
    @Autowired
    private TransactionRepository transRepo;

    @Autowired
    public DatabaseLoader(CustomerRepository custRepo, AccountRepository acctRepo, TransactionRepository transRepo) {
		this.custRepo = custRepo;
		this.acctRepo = acctRepo;
		this.transRepo = transRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Customer chris = new Customer("cj", "Chris Jabb","fearandloathinginUSSR@aol.com","nowhere", "1233334545");
		Customer matt = new Customer("mk", "Matty K","servethesovietunion@lol.com","everwhere","2223334545");
		Customer nat = new Customer("nn", "Natasha Ng","nn@yahoo.com","Seattle","3123334545");
		Customer dan = new Customer("db", "Danny B","danny@netscape.com","somewhere", "693334545");
		
		Account chrisAcct = new Account();
		chris.addCustomerToAccount(chrisAcct);
		System.out.println(chrisAcct.getCustomersOnAccount());
		System.out.println(chris.getAccounts());
		Account natAcct = new Account(AccountType.SAVINGS);
		nat.addCustomerToAccount(natAcct);
		Account danXMatt = new Account(AccountType.BROKERAGE);
		dan.addCustomerToAccount(danXMatt);
		matt.addCustomerToAccount(danXMatt);
		
		Transaction trans1 = chrisAcct.deposit(100.0, "Initial deposit");
		Transaction trans2 = chrisAcct.withdraw(10.0, "Money for lunch");
		Transaction trans3 = danXMatt.deposit(1000.0, "Init dep");
		Transaction trans4 = natAcct.deposit(1000000.0, "Nats a high roller");
		
		this.custRepo.save(chris);
		this.custRepo.save(matt);
		this.custRepo.save(nat);
		this.custRepo.save(dan);
		
		this.acctRepo.save(chrisAcct);
		this.acctRepo.save(natAcct);
		this.acctRepo.save(danXMatt);
		
		this.transRepo.save(trans1);
		this.transRepo.save(trans2);
		this.transRepo.save(trans3);
		this.transRepo.save(trans4);
	}
    
}