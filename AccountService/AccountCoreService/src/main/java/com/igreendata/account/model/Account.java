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
    @Setter
    private Long id;

    @Getter
    @Setter
    private String accountName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "account_type_id")
    @Setter
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_type_id")
    @Setter
    private CurrencyType currencyType;

    @Getter
    @Setter
    private Date balanceDate;

    @Getter
    @Setter
    private Double availableBalance;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @Getter
    @Setter
    private Set<Transaction> transactions;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @Setter
    @Getter
    private User user;

}
