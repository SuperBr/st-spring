package com.spring.day_9.bean;

public class Pserson {
    private String name;

    private Integer age;


    public String getName() {
        return name;
    }

    public Pserson setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Pserson setAge(Integer age) {
        this.age = age;
        return this;
    }
}
