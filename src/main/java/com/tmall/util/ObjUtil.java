package com.tmall.util;

import java.lang.reflect.Constructor;

public class ObjUtil {

   public  ObjUtil(String name,int age){
       this.name=name;
       this.age=age;
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
}
