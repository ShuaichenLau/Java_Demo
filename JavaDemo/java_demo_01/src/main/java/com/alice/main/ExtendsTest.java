package com.alice.main;

public class ExtendsTest {

    public static void main(String[] args) {

        Person person = new Person();
        person.setId("aa");
        person.setAddress("beijing");

        System.out.println(person.getAddress());

        System.out.println(person.getPerson());

    }
}


abstract class Hello {

    private String name;
    private String age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


class Person extends Hello implements HelloPerson{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPerson() {
        return "abc";
    }
}


interface HelloPerson{
    String getPerson();
}