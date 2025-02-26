package com.example.demo.mapper;

import com.example.demo.Entity.Account;
import com.example.demo.dto.AccountDto;


public class AccountMapper {
public static Account mapToAccount(AccountDto accountDto) {
	Account account=new Account(accountDto.getId(),accountDto.getAccountHoldername(),accountDto.getBalance());
	return account;
								
}
public static AccountDto mapToAccountDto(Account account) {
	AccountDto accountdto=new AccountDto(account.getId(),
										account.getAccountHoldername(),
										account.getBalance());
	return accountdto;
}
}
