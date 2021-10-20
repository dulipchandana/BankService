package com.igreendata.account.dto;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountDto extends BaseDto {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd/MM/YYYY");

    @Getter
    private final String accountType;

    @Getter
    private String balanceDate;

    @Getter
    private final Double availableBalance;

    public AccountDto(final Long accountNumber, final String accountName, final String currency,
                      final String accountType, final Date balanceDate, final Double availableBalance) {
        super(accountNumber, accountName, currency);
        this.accountType = accountType;
        this.availableBalance = availableBalance;
        setBalanceDate(balanceDate);


    }

    public void setBalanceDate(final Date balanceDate) {
        this.balanceDate = dateFormat.format(balanceDate);
    }


}