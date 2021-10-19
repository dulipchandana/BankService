package com.igreendata.account.service;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Qualifier("com.igreendata.account.service.TransactionServiceImpl")
public class TransactionServiceImpl implements BankService<TransactionDto>{

    @Autowired
    AccountRepository<TransactionDto> transactionRepository;

    @Override
    public Page<TransactionDto> getDtoById(Long accountId, Pageable pageable) {
        Page<TransactionDto> transactionDtoResults = transactionRepository.findAccountAccountId
                (accountId,pageable);
        if(!transactionDtoResults.isEmpty()){
            return transactionDtoResults;
        }else{
            throw  new ResourceNotFoundException("Transaction", "accountId", accountId);
        }
    }
}
