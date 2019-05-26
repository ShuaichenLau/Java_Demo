package com.alice.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
@Data
public class User {


        private String name;

        private boolean isHappy;

        @Email
        private String email;



}
