package com.wzq.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private Date birthday;
    private Character sex;
    private String address;

    public User() {
    }

    public User(int id, String username, Date birthday, Character sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }
}
