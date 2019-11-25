package com.alice.exercise.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {

	private static final long serialVersionUID = 4685752006887241237L;

	private int id;
	private String name;
	private String address;
	private int age;

	private static Person getPerson() {
		return new Person();
	}

	private Person() {
	}

}
