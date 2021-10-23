package com.igreendata.account.controller;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.model.Account;
import com.igreendata.account.util.AccountConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

/**
 * AccountController for handle /accounts/ and /transactions/ api .
 * @author Dulip Chandana
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="accountServices", description="Bank service in Account Department.")
public class AccountController {

	@Autowired
	@Qualifier("com.igreendata.account.service.AccountServiceImpl")
	private BankService<AccountDto> accountService;

	@Autowired
	@Qualifier("com.igreendata.account.service.TransactionServiceImpl")
	private BankService<TransactionDto> transactionService;


	@GetMapping("/accounts/{userId}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AccountConstant.PAGE, dataType = AccountConstant.INTEGER, paramType = AccountConstant.QUERY,
					value = AccountConstant.PAGE_DESC),
			@ApiImplicitParam(name = AccountConstant.SIZE, dataType = AccountConstant.INTEGER, paramType = AccountConstant.QUERY,
					value = AccountConstant.SIZE_DESC),
			@ApiImplicitParam(name = AccountConstant.SORT, allowMultiple = true, dataType = AccountConstant.STRING, paramType = AccountConstant.QUERY,
					value = AccountConstant.SORT_DESC)
	})
	public Page<AccountDto> getAccountsByUserId(@PathVariable(value = "userId") Long userId,Pageable pageable) {
		return accountService.getDtoById(userId,pageable);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = AccountConstant.PAGE, dataType = AccountConstant.INTEGER, paramType = AccountConstant.QUERY,
					value = AccountConstant.PAGE_DESC),
			@ApiImplicitParam(name = AccountConstant.SIZE, dataType = AccountConstant.INTEGER, paramType = AccountConstant.QUERY,
					value = AccountConstant.SIZE_DESC),
			@ApiImplicitParam(name = AccountConstant.SORT, allowMultiple = true, dataType = AccountConstant.STRING, paramType = AccountConstant.QUERY,
					value = AccountConstant.SORT_DESC)
	})
	@GetMapping("transactions/{accountId}")
	public Page<TransactionDto> getTransactionsByAccountId(@PathVariable(value = "accountId")
																   Long accountId,Pageable pageable){
		return transactionService.getDtoById(accountId,pageable);
	}
}
