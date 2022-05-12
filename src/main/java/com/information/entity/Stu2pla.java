package com.information.entity;

public class Stu2pla extends Stu2plaKey {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}