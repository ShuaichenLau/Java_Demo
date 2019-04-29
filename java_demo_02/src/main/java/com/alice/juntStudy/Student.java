package com.alice.juntStudy;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

@Data
public class Student {

    private String name;

    private boolean isHappy;

    @Email
    private String email;


}
