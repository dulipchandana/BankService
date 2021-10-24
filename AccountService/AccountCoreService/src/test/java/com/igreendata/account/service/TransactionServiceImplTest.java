package com.igreendata.account.service;

import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.exception.IncorrectParameterException;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.repository.AccountRepository;
import com.igreendata.account.util.TransactionType;
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
 * Test cases for TransactionServiceImpl.
 *
 * @author Dulip Chandana
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Mock
    AccountRepository accountRepository;

    /**
     * Check transaction happy path
     */
    @Test
    public void getDtoByIdWithTransaction() {
        PageRequest paginacao = PageRequest.of(0, 2);
        TransactionDto transactionDto = new TransactionDto(12L, "testName", "USD", new Date(), 2D, 5D, TransactionType.Credit, "NC");
        List<TransactionDto> transactionDtoList = Arrays.asList(transactionDto);
        Page<TransactionDto> transactionsPage = new PageImpl<>(transactionDtoList, paginacao, transactionDtoList.size());

        Mockito.when(accountRepository.findAccountAccountId(1L, paginacao)).thenReturn(transactionsPage);
        assertThat(transactionService.getDtoById(1L, paginacao)).isEqualTo(transactionsPage);

    }

    /**
     * check no result in db
     */
    @Test(expected = ResourceNotFoundException.class)
    public void getDtoByIdWithOutAccount() {
        PageRequest paginacao = PageRequest.of(0, 2);
        List<TransactionDto> transactionList = Arrays.asList();
        Page<TransactionDto> transactionDtoPage = new PageImpl<>(transactionList, paginacao, transactionList.size());

        Mockito.when(accountRepository.findAccountAccountId(1L, paginacao)).thenReturn(transactionDtoPage);
        transactionService.getDtoById(1L, paginacao);

    }

    /**
     * test pagination exception
     */
    @Test(expected = IncorrectParameterException.class)
    public void getDtoByIdWithPaginationException() {
        PageRequest paginacao = PageRequest.of(0, 2);
        Mockito.when(accountRepository.findAccountAccountId(1L, paginacao)).thenThrow(InvalidDataAccessApiUsageException.class);
        transactionService.getDtoById(1L, paginacao);

    }


}
