package com.alice.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

@Data
public class User implements Serializable {


        private static final long serialVersionUID = 5596069743205913976L;
        private String name;

        private boolean isHappy;

        @Email
        private String email;



}
