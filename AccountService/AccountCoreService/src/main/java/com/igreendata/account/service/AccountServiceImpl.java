package com.igreendata.account.service;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.model.Account;
import com.igreendata.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@Qualifier("com.igreendata.account.service.AccountServiceImpl")
public class AccountServiceImpl implements BankService<AccountDto>{

    @Autowired
    AccountRepository<AccountDto> accountRepository;
    @Override
    public Page<AccountDto> getDtoById(Long id, Pageable pageable) {

        Page<AccountDto> accountDtoResults = accountRepository.findAccountByUserId(id,pageable);
        if(!accountDtoResults.isEmpty()){
            return accountDtoResults;
        }else{
            throw  new ResourceNotFoundException("Account", "userId", id);
        }
    }
}