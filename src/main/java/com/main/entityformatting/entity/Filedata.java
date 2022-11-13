package com.main.entityformatting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filedata")
@NoArgsConstructor
@Getter
@Setter
public class Filedata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String amount;
    private String date;
    private String cost;
    private String discount;

    public Filedata(String name, String amount, String date, String cost, String discount) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.cost = cost;
        this.discount = discount;
    }

}
