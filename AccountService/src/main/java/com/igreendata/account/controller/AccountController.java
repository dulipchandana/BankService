package com.igreendata.account.controller;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.igreendata.account.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	@Qualifier("com.igreendata.account.service.AccountServiceImpl")
	BankService<AccountDto> accountService;

	@Autowired
	@Qualifier("com.igreendata.account.service.TransactionServiceImpl")
	BankService<TransactionDto> transactionService;


	@GetMapping("/accounts/{userId}")
	public Page<AccountDto> getAccountsByUserId(@PathVariable(value = "userId") Long userId,Pageable pageable) {
		return accountService.getDtoById(userId,pageable);
	}

	@GetMapping("transactions/{accountId}")
	public Page<TransactionDto> getTransactionsByAccountId(@PathVariable(value = "accountId")
																   Long accountId,Pageable pageable){
		return transactionService.getDtoById(accountId,pageable);
	}
}
