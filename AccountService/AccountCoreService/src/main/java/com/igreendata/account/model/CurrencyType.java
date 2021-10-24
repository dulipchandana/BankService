package com.igreendata.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * CurrencyType represent currency_type table .
 *
 * @author Dulip Chandana
 */
@Entity
@Table(name = "currency_type")
@Getter
@Setter
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CurrencyType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_type_id")
    private Long id;

    @Setter
    private String currency;


}
