package com.example.demo_26_arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyClass {
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList<Integer>();
        System.out.println("the size is " + arrayList.size());
        arrayList.add(1);
        System.out.println("the size is " + arrayList.size());
        for(int i = 2; i<12; i++) {
            arrayList.add(i);
            System.out.println("the size is " + arrayList.size());
        }
        System.out.println(arrayList);


        try {
            Field f = ArrayList.class.getDeclaredField("elementData");
            f.setAccessible(true);
            System.out.println(f + " is begin----------");
            for(Object object : (Object[])f.get(arrayList)) {
                System.out.print(object + " ");
            }
            System.out.println();
            System.out.println(f + " is end-----------");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        arrayList.add(null);
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        arrayList.add(2,22);
        System.out.println(arrayList.size());
        System.out.println(arrayList);
    }
}
