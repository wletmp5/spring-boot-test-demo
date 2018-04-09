package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Account(String name) {
        this.name = name;
    }
}
