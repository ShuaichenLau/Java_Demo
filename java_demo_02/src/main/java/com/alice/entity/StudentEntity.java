package com.alice.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

@Data
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 3372835164772833638L;
    private String name;

    private boolean isHappy;

    @Email
    private String email;


}
