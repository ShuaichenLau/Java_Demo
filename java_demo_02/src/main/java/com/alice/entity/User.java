package com.alice.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

public class User {
    @Data
    public static class StudentEntity {

        private String name;

        private boolean isHappy;

        @Email
        private String email;


    }
}
