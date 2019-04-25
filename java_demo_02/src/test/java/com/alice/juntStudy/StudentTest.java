package com.alice.juntStudy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student = null;


    @Test
    public void getName() {
        assertEquals("alice",student.getName());
        System.out.println(student.isHappy());
        assertFalse(student.isHappy());
    }

    @Before
    public void setUp() throws Exception {
        student = new Student();
        student.setName("alice");
        student.setHappy(false);
    }

    @After
    public void tearDown() throws Exception {
        student = null;
    }
}