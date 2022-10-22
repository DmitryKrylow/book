package com.example.book;

import javax.lang.model.element.NestingKind;

public class User {
    private String id;
    private String name;
    private String surname;
    private String lastame;
    private String money;
    private String spec;

    public User(String[] parameters) {
        this.id = parameters[0];
        this.name = parameters[1];
        this.surname = parameters[2];
        this.lastame = parameters[3];
        this.money = parameters[4];
        this.spec = parameters[5];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastame() {
        return lastame;
    }

    public void setLastame(String lastame) {
        this.lastame = lastame;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
