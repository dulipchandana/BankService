package com.igreendata.account.model;

import com.igreendata.account.util.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Transaction represent transaction table .
 * @author Dulip Chandana
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    @Getter
    private Long id;

    @NotBlank
    @Getter
    private Date valueDate;

    @Enumerated(EnumType.STRING)
    @Getter
    private TransactionType transactionType;

    @Getter
    private Double creditAmount;

    @Getter
    private Double debitAmount;

    @Getter
    private String transactionNarrative;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

}
