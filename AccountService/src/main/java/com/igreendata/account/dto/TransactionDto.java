package com.igreendata.account.dto;

import com.igreendata.account.util.TransactionType;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDto extends BaseDto{

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("MMM.dd,YYYY");

    @Getter
    private String valueDate;

    @Getter
    private Double creditAmount;

    @Getter
    private Double debitAmount;

    @Getter
    private TransactionType transactionType;

    @Getter
    private String transactionNarrative;

    public void setValueDate(Date valueDate) {
        this.valueDate = dateFormat.format(valueDate);;
    }

    public TransactionDto(final Long accountNumber, final String accountName, final String currency ,
                          final Date valueDate , final Double creditAmount, final Double debitAmount ,
                          final TransactionType transactionType,final String transactionNarrative ) {
        super(accountNumber, accountName, currency);
        this.setValueDate(valueDate);
        this.creditAmount = creditAmount;
        this.debitAmount =debitAmount;
        this.transactionType = transactionType;
        this.transactionNarrative = transactionNarrative;
    }
}
