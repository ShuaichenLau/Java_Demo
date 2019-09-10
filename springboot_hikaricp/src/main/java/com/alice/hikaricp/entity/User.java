package com.alice.hikaricp.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String userId; //int(11) NOT NULL AUTO_INCREMENT,
    private String userName; //varchar(255) NOT NULL,
    private String password; //varchar(255) NOT NULL,
    private String phone; //varchar(255) NOT NULL,

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
