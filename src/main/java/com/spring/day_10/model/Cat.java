package com.spring.day_10.model;

import java.io.Serializable;

public class Cat implements Serializable{

    private  String name;

    private  Integer Age;

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return Age;
    }

    public Cat setAge(Integer age) {
        Age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
