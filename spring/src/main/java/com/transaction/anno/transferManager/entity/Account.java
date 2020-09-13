package com.transaction.anno.transferManager.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String uname;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
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
