package com.igreendata.account.service;

import com.igreendata.account.model.Account;
import com.igreendata.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Component
@Qualifier("com.igreendata.account.service.AccountServiceImpl")
public class AccountServiceImpl implements BankService<Account>{

    @Autowired
    AccountRepository accountRepository;
    @Override
    public Page<Account> getDtoById(Long id, Pageable pageable) {
        return accountRepository.findAccountByUserId(id,pageable);
    }
}
