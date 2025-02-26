package com.example.demo.Service.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.Entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.Accountrepository;
import com.example.demo.Service.AccountService;

@Service
public class AccountServiceimpl  implements AccountService{
	@Autowired
	private Accountrepository accountrepository;	

	
	public  AccountDto AccountServiceimpl(Accountrepository accountrepository) {
		//return this.accountrepository = accountrepository;
		return null;
	}

	@Override
	public AccountDto createaccount(AccountDto accountDto) {
		Account account =AccountMapper.mapToAccount(accountDto);
		Account savedaccount=accountrepository.save(account);

		return AccountMapper.mapToAccountDto(savedaccount); 
	}

	@Override
	public AccountDto getAccountById(Long id) {

		Account account=accountrepository.findById(id).orElseThrow(() ->new  RuntimeException("id does not exists"));
		return AccountMapper.mapToAccountDto(account);


	}
	@Override
	public AccountDto deposit(long id, double amount) {

		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		double	balance=account.getBalance();
		balance=balance+amount;
		account.setBalance(balance);
		Account savedaccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedaccount);
	}

	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		if (account.getBalance()<=amount) {
			throw new RuntimeException("infsuffient balance");
		}

		double total=account.getBalance()-amount;

		account.setBalance(total);
		Account savedacAccount=accountrepository.save(account);

		return AccountMapper.mapToAccountDto(savedacAccount);
	}

	@Override
	public List<AccountDto> getAll() {
		List<Account> accounts=accountrepository.findAll();
		return (List<AccountDto>) accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		
		accountrepository.deleteById(id);
	}
}

