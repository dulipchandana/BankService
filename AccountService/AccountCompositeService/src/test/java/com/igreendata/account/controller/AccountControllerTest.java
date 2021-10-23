package com.igreendata.account.controller;

import com.igreendata.account.dto.AccountDto;
import com.igreendata.account.dto.TransactionDto;
import com.igreendata.account.exception.ResourceNotFoundException;
import com.igreendata.account.service.AccountServiceImpl;
import com.igreendata.account.service.TransactionServiceImpl;
import com.igreendata.account.util.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * AccountControllerTest cover possible scenarios .
 * @author Dulip Chandana
 *
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountServiceImpl accountService;

    @MockBean
    private TransactionServiceImpl transactionService;

    @Test
    public void getAccountsByUserIdWithResult() throws Exception {
        PageRequest paginacao = PageRequest.of(0, 2);
        AccountDto accountDto1 = new AccountDto(99L, "test1", "fsdf", "jj", new Date(), 5D);
        AccountDto accountDto2 = new AccountDto(100L, "test2", "fsdf", "jj", new Date(), 5D);
        List<AccountDto> acList = Arrays.asList(accountDto1, accountDto2);
        Page<AccountDto> accountsPage = new PageImpl<>(acList, paginacao, acList.size());
        given(accountService.getDtoById(1L, paginacao)).willReturn(accountsPage);
        this.mockMvc.perform(get("/api/accounts/1?page=0&size=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].accountNumber").value(99));

        //verify the behavior
        verify(accountService).getDtoById(1L, paginacao);


    }

    @Test
    public void getAccountsByUserIdWithOutResult() throws Exception {
        PageRequest paginacao = PageRequest.of(0, 2);
        given(accountService.getDtoById(1L, paginacao)).willThrow(ResourceNotFoundException.class);
        this.mockMvc.perform(get("/api/accounts/1?page=0&size=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        //verify the behavior
        verify(accountService).getDtoById(1L, paginacao);

    }

    @Test
    public void getTransactionsByAccountIdWithResult() throws Exception {
        PageRequest paginacao = PageRequest.of(0, 2);
        TransactionDto tansactionDto = new TransactionDto(1L, "test", "testCr", new Date(), 12D, 3D, TransactionType.Credit, "NC");
        List<TransactionDto> transactionDtoList = Arrays.asList(tansactionDto);
        Page<TransactionDto> TransactionDtoPage = new PageImpl<>(transactionDtoList, paginacao, transactionDtoList.size());
        given(transactionService.getDtoById(1L, paginacao)).willReturn(TransactionDtoPage);
        this.mockMvc.perform(get("/api/transactions/1?page=0&size=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.[0].accountNumber").value(1));

        //verify the behavior
        verify(transactionService).getDtoById(1L, paginacao);


    }

    @Test
    public void getTransactionsByAccountIdWithOutResult() throws Exception {
        PageRequest paginacao = PageRequest.of(0, 2);
        given(transactionService.getDtoById(1L, paginacao)).willThrow(ResourceNotFoundException.class);
        this.mockMvc.perform(get("/api/transactions/1?page=0&size=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        //verify the behavior
        verify(transactionService).getDtoById(1L, paginacao);
    }
}
