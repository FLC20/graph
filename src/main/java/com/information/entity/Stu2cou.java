package com.information.entity;

public class Stu2cou extends Stu2couKey {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}