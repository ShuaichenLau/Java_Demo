package com.alice.entity;


import java.io.Serializable;

public class AppEntity implements Serializable {

    private int id; //int(11) NOT NULL AUTO_INCREMENT,
    private String app_name; //varchar(255) DEFAULT NULL,
    private String app_id; //varchar(255) DEFAULT NULL,
    private String app_secret; //varchar(255) DEFAULT NULL,
    private int is_flag; //varchar(255) DEFAULT NULL,
    private String access_token; //varchar(255) DEFAULT NULL

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public int getIs_flag() {
        return is_flag;
    }

    public void setIs_flag(int is_flag) {
        this.is_flag = is_flag;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
