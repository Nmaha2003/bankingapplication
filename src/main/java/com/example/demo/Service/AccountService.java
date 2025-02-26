package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.AccountDto;

public interface AccountService {
	AccountDto createaccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(long id,double amount);
	AccountDto withdraw(long id,double amount);
	List<AccountDto> getAll();
	void deleteAccount(long id);
}
