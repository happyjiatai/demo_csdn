package com.example.demo_28_hashtable;

import java.util.Hashtable;

public class MyClass {
    public static void main(String[] args){
        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        System.out.println(numbers);

        Integer n = numbers.get("two");
        if (n != null) {
            System.out.println("two = " + n);
        }
    }
}
