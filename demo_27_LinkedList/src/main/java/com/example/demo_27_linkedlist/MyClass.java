package com.example.demo_27_linkedlist;

import java.util.LinkedList;

public class MyClass {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        for (int i = 1; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.print(linkedList);
    }
}
