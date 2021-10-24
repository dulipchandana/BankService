package com.igreendata.account.dto;

import lombok.Getter;

/**
 * BaseDto hold common values for /transactions/ and /accounts/ api.
 *
 * @author Dulip Chandana
 */
public class BaseDto {

    @Getter
    private Long accountNumber;

    @Getter
    private String accountName;

    @Getter
    private String currency;

    /**
     * Super constructor
     *
     * @param accountNumber
     * @param accountName
     * @param currency
     */
    public BaseDto(final Long accountNumber, final String accountName, final String currency) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.currency = currency;
    }
}
