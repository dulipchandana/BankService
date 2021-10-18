package com.igreendata.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    @Getter
    private Long id;

    @NotBlank
    @Getter
    private String accountName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type_id")
    @Getter
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_type_id")
    @Getter
    private CurrencyType currencyType;

    @NotBlank
    @Getter
    private Date balanceDate;

    @NotBlank
    @Getter
    private Double availableBalance;

    @OneToMany(mappedBy="account",fetch = FetchType.LAZY)
    @Getter
    private Set<Transaction> transactions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
