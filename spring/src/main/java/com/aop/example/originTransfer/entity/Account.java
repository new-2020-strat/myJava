package com.aop.example.originTransfer.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    private String uname;
    private float money;

    public int getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public float getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", money=" + money +
                '}';
    }
}
