package com.alice.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsListTest {

    public static void main(String[] args) {


        List<String> strings = Arrays.asList("a", "b", "c");

        ArrayList<String> strings1 = new ArrayList<>(strings);

        strings1.add("d");

        System.out.println(strings.size());
        System.out.println(strings1.size());

    }
}
