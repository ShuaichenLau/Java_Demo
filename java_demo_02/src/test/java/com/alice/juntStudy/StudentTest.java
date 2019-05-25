package com.alice.juntStudy;


import com.alice.entity.StudentEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private StudentEntity student = null;


    @Test
    public void getName() {
        assertEquals("alice",student.getName());
        System.out.println(student.isHappy());
        assertFalse(student.isHappy());
//        assertTrue(student.isHappy());
    }

    @Before
    public void setUp() throws Exception {
        student = new StudentEntity();
        student.setName("alice");
        student.setHappy(false);
    }

    @After
    public void tearDown() throws Exception {
        student = null;
    }
}