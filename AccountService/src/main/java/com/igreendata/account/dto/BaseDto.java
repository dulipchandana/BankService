package com.igreendata.account.dto;

import lombok.Getter;
import lombok.Setter;

public class BaseDto {

    @Getter
    private Long accountNumber;

    @Getter
    private String accountName;

    @Getter
    private String currency;

    public BaseDto(Long accountNumber, String accountName, String currency) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.currency = currency;
    }
}
