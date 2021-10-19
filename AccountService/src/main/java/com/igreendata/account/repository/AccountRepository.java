package com.igreendata.account.repository;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT new com.igreendata.account.dto.AccountDto(a.id,a.accountName,a.currencyType.currency,a.accountType.accountType,a.balanceDate,a.availableBalance) " +
            "FROM Account a WHERE a.user.id = ?1")
    Page<AccountDto> findAccountByUserId(Long userId, Pageable pageable);

    @Query("SELECT a FROM Account a WHERE a.id = ?1")
    Page<Account> findAccountAccountId(Long accountId,Pageable pageable);


}
