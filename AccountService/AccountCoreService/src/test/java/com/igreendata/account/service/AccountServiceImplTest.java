package com.igreendata.account.service;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.exception.IncorrectParameterException;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for AccountServiceImpl.
 *
 * @author Dulip Chandana
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    AccountRepository accountRepository;


    /**
     * Check account happy path
     */
    @Test
    public void getDtoByIdWithAccount() {
        PageRequest paginacao = PageRequest.of(0, 2);
        AccountDto accountDto1 = new AccountDto(99L, "test1", "fsdf", "jj", new Date(), 5D);
        List<AccountDto> acList = Arrays.asList(accountDto1);
        Page<AccountDto> accountsPage = new PageImpl<>(acList, paginacao, acList.size());

        Mockito.when(accountRepository.findAccountByUserId(1L, paginacao)).thenReturn(accountsPage);
        assertThat(accountService.getDtoById(1L, paginacao)).isEqualTo(accountsPage);

    }

    /**
     * check no result in db
     */
    @Test(expected = ResourceNotFoundException.class)
    public void getDtoByIdWithOutAccount() {
        PageRequest paginacao = PageRequest.of(0, 2);
        List<AccountDto> acList = Arrays.asList();
        Page<AccountDto> accountsPage = new PageImpl<>(acList, paginacao, acList.size());

        Mockito.when(accountRepository.findAccountByUserId(1L, paginacao)).thenReturn(accountsPage);
        accountService.getDtoById(1L, paginacao);

    }

    /**
     * test pagination exception
     */
    @Test(expected = IncorrectParameterException.class)
    public void getDtoByIdWithPaginationException() {
        PageRequest paginacao = PageRequest.of(0, 2);
        Mockito.when(accountRepository.findAccountByUserId(1L, paginacao)).thenThrow(InvalidDataAccessApiUsageException.class);
        accountService.getDtoById(1L, paginacao);

    }


}
