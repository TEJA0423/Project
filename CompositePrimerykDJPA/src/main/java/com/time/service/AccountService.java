package com.time.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.time.repository.AccountRepository;
import com.time.repository.Account;
import com.time.repository.AccountPK;
@Service
public class AccountService {

	private AccountRepository accRepo;

	public AccountService(AccountRepository accRepo) {
		this.accRepo = accRepo;
	}

	public void getDataUsingPK() {

		AccountPK pk = new AccountPK();
		pk.setAccId(101);;
		pk.setAccType("CURRENT");;
		pk.setHolderName("IBM");;


		Optional<Account> findById = accRepo.findById(pk);
		if (findById.isPresent()) {
			System.out.println(findById.get());
		}
	}

	public void saveAccData() {
		AccountPK pk = new AccountPK();
		pk.setAccId(104);;
		pk.setAccType("SAVINGS");;
		pk.setHolderName("TCS");;

		Account acc = new Account();
		acc.setBranchName("Ameerpet");
		acc.setMinBal(5000.00);

		acc.setAccPk(pk); // setting pk class obj to entity obj

		accRepo.save(acc);
	}

}
