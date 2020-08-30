package com.crud.config.entity;

import java.util.Date;

public class UserFieldDiff{
    public Integer id_new;
    public String userName_new;
    public Date birthday_new;
    public char sex_new;
    public String address_new;

    public Integer getId_new() {
        return id_new;
    }

    public void setId_new(Integer id_new) {
        this.id_new = id_new;
    }

    public String getUserName_new() {
        return userName_new;
    }

    public void setUserName_new(String userName_new) {
        this.userName_new = userName_new;
    }

    public Date getBirthday_new() {
        return birthday_new;
    }

    public void setBirthday_new(Date birthday_new) {
        this.birthday_new = birthday_new;
    }

    public char getSex_new() {
        return sex_new;
    }

    public void setSex_new(char sex_new) {
        this.sex_new = sex_new;
    }

    public String getAddress_new() {
        return address_new;
    }

    public void setAddress_new(String address_new) {
        this.address_new = address_new;
    }

    @Override
    public String toString() {
        return "UserFieldDiff{" +
                "id_new=" + id_new +
                ", userName_new='" + userName_new + '\'' +
                ", birthday_new=" + birthday_new +
                ", sex_new=" + sex_new +
                ", address_new='" + address_new + '\'' +
                '}';
    }
}
