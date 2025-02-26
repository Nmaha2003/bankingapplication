 package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AccountService;
import com.example.demo.dto.AccountDto;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountservice;

	public AccountService getAccountservice() {
		return accountservice;
	}

	public void setAccountservice(AccountService accountservice) {
		this.accountservice = accountservice;
	}
	//create api to add account
	@PostMapping("/save")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accdto){
		return new ResponseEntity<>(accountservice.createaccount(accdto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccounntById(@PathVariable long id){
		AccountDto accdto=accountservice.getAccountById(id);
		return ResponseEntity.ok(accdto);
	}
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long id,@RequestBody Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDto accountdto=accountservice.deposit(id,amount);
		return ResponseEntity.ok(accountdto);
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id,@RequestBody Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDto accountDto=accountservice.withdraw(id,amount);
		return (ResponseEntity<AccountDto>) ResponseEntity.ok(accountDto);
	}
	@GetMapping
	public ResponseEntity<List<AccountDto>> GetAllAccounts(){
		List<AccountDto> acc=accountservice.getAll();
		return ResponseEntity.ok(acc);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		accountservice.deleteAccount(id);
		return ResponseEntity.ok("Account deleted");
	}
}
