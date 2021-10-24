package com.igreendata.account.repository;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Date;

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

    @Test
    public void findAccountByUserId_if_repository_is_empty(){
        PageRequest paginacao = PageRequest.of(0, 2);
        Page<AccountDto> accountDtos = accountRepository.findAccountByUserId(1L,paginacao);
        assertThat(accountDtos.isEmpty()).isTrue();
    }

}
