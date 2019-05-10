package com.ruju.mylearn;

import java.io.Serializable;

public class Userinfo implements Serializable {
    public String name;
    public int age;

    public Userinfo(String name, int age) {
        this.name = name;
        this.age = age;
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
}
