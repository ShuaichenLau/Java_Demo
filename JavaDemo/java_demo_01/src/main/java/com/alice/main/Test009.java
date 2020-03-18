package com.alice.main;

import com.alice.entity.User;
import org.openjdk.jol.info.ClassLayout;

public class Test009 {

    public static void main(String[] args) throws Exception {


        Thread.sleep(5000);

        User user = new User();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("=====================================================");

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());





    }
}
