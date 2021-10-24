package com.igreendata.account.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Account class represent the account table.
 *
 * @author Dulip Chandana
 */
@Entity
@Table(name = "account")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String accountName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type_id")
    @Getter
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_type_id")
    @Getter
    private CurrencyType currencyType;

    @Getter
    @Setter
    private Date balanceDate;

    @Getter
    @Setter
    private Double availableBalance;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @Getter
    private Set<Transaction> transactions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
