package com.alice.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Student implements Serializable {

    private static final int v = 8008;

    private Integer id;
    private String name;
    private String address;
    private Integer age;

    private Timestamp date;

}
