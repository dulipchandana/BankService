package com.igreendata.account.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService<T> {

    Page<T> getDtoById(Long id, Pageable pageable);

}
