package com.igreendata.account.model;

import com.igreendata.account.util.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Transaction represent transaction table .
 *
 * @author Dulip Chandana
 */
@Entity
@Table(name = "transaction")
public class Transaction extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    @Getter
    private Long id;

    @Getter
    @Setter
    private Date valueDate;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private TransactionType transactionType;

    @Getter
    @Setter
    private Double creditAmount;

    @Getter
    @Setter
    private Double debitAmount;

    @Getter
    @Setter
    private String transactionNarrative;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Setter
    private Account account;

}
