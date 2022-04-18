package com.bankapplication.cards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
}
