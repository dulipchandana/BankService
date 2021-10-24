package com.igreendata.account.repository;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.model.*;
import com.igreendata.account.util.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for AccountRepository.
 *
 * @author Dulip Chandana
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository<AccountDto> accountRepository;

    @Autowired
    private AccountRepository<TransactionDto> transactionRepository;

    @Test
    public void findAccountByUserId_if_repository_is_empty() {
        PageRequest paginacao = PageRequest.of(0, 2);
        Page<AccountDto> accountDtos = accountRepository.findAccountByUserId(1L, paginacao);
        assertThat(accountDtos.isEmpty()).isTrue();
    }

    @Test
    public void findAccountByUserId_if_repository_is_avialbale() {
        PageRequest paginacao = PageRequest.of(0, 1);
        User user = new User();
        user.setUserName("Test UN");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        CurrencyType ct = new CurrencyType();
        ct.setCurrency("USD");
        entityManager.persist(ct);

        AccountType at = new AccountType();
        at.setAccountType("Savings");
        entityManager.persist(at);

        Account account = new Account();
        account.setAccountName("Test");
        account.setUser(user);
        account.setAvailableBalance(12D);
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        account.setBalanceDate(new Date());
        account.setCurrencyType(ct);
        account.setAccountType(at);

        entityManager.persist(user);
        Account accountPersist = entityManager.persist(account);
        entityManager.flush();
        Page<AccountDto> accountDtos = accountRepository.findAccountByUserId(accountPersist.getUser().getId(), paginacao);
        assertThat(accountDtos.getTotalElements()).isEqualTo(1);
        assertThat(accountDtos.stream().allMatch(a -> a.getAvailableBalance() == 12D)).isTrue();
    }

    @Test
    public void findAccountAccountId_if_repository_is_empty() {
        PageRequest paginacao = PageRequest.of(0, 1);
        Page<TransactionDto> transactionDtoPageDtos = transactionRepository.findAccountAccountId(1L, paginacao);
        assertThat(transactionDtoPageDtos.isEmpty()).isTrue();
    }

    @Test
    public void findAccountAccountId_if_repository_is_avialbale() {
        PageRequest paginacao = PageRequest.of(0, 1);
        User user = new User();
        user.setUserName("Test UN");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        CurrencyType ct = new CurrencyType();
        ct.setCurrency("USD");
        entityManager.persist(ct);

        AccountType at = new AccountType();
        at.setAccountType("Savings");
        entityManager.persist(at);

        Account account = new Account();
        account.setAccountName("Test");
        account.setUser(user);
        account.setAvailableBalance(12D);
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        account.setBalanceDate(new Date());
        account.setCurrencyType(ct);
        account.setAccountType(at);

        entityManager.persist(user);
        Account accountPersist = entityManager.persist(account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.Credit);
        transaction.setTransactionNarrative("Test");
        transaction.setCreditAmount(14D);
        transaction.setDebitAmount(300D);
        transaction.setValueDate(new Date());
        transaction.setCreatedAt(new Date());
        transaction.setUpdatedAt(new Date());
        transaction.setAccount(accountPersist);
        entityManager.persist(transaction);
        entityManager.flush();
        Page<TransactionDto> transactionDtos = transactionRepository.findAccountAccountId(accountPersist.getUser().getId(), paginacao);
        assertThat(transactionDtos.getTotalElements()).isEqualTo(1);
        assertThat(transactionDtos.stream().allMatch(t -> t.getCreditAmount()== 14D)).isTrue();
    }

}
