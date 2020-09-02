package com.habibank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.habibank.model.Account;
import com.habibank.model.AccountType;
import com.habibank.model.Customer;
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
		Customer chris = new Customer("cj","Chris Jabb","cj@aol.com","nowhere", PhoneNumberUtil.getInstance().getExampleNumber("1"));
		Customer matt = new Customer("mk","Matty K","mk@lol.com","everwhere", PhoneNumberUtil.getInstance().getExampleNumber("1"));
		Customer nat = new Customer("nn","Natasha Ng","nn@yahoo.com","Seattle", PhoneNumberUtil.getInstance().getExampleNumber("1"));
		Customer dan = new Customer("db","Danny B","danny@netscape.com","somewhere", PhoneNumberUtil.getInstance().getExampleNumber("1"));
		
		Account chrisAcct = new Account();
		chris.addCustomerToAccount(chrisAcct);
		System.out.println(chrisAcct.getCustomersOnAccount());
		System.out.println(chris.getAccounts());
		Account natAcct = new Account(AccountType.SAVINGS);
		nat.addCustomerToAccount(natAcct);
		Account danXMatt = new Account(AccountType.BROKERAGE);
		dan.addCustomerToAccount(danXMatt);
		matt.addCustomerToAccount(danXMatt);
		
		this.custRepo.save(chris);
		this.custRepo.save(matt);
		this.custRepo.save(nat);
		this.custRepo.save(dan);
		
		this.acctRepo.save(chrisAcct);
		this.acctRepo.save(natAcct);
		this.acctRepo.save(danXMatt);
		
		//Transactions
	}
    
}