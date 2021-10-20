package com.igreendata.account.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * BaseDto hold common values for /transactions/ and /accounts/ api.
 * @author Dulip Chandana
 *
 */
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
