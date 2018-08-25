package com.example.demo_81_arraylist;

import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]){
        ArrayList arr =new ArrayList();
        arr.add("111");
        arr.add("222");
        ArrayList arr1 = arr;
        arr.remove(0);
        System.out.println(arr + "----" + arr1);

    }
}
