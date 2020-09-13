package com.bindData.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
public class Acount implements Serializable {
    private String uname;
    private String password;
    private String money;
    private User user;
    private List<User> list;
    private Map<String,User> map;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", money='" + money + '\'' +
                ", user=" + user +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
