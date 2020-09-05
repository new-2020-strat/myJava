package com.multilist.entity;

public class AccountUser extends Account{
    private String userName;
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+"   AccountUser{"+
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
