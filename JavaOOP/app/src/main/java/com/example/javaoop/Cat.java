package com.example.javaoop;

import android.util.Log;

public class Cat extends Animal {
    int age;
    String name;


    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void talk() {
        Log.d("talk()", name + " " + age);
    }
}
