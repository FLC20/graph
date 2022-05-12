package com.information.entity;

public class Nodes {
    private String id;

    private String name;

    private Integer symbolsize;

    private Integer category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSymbolsize() {
        return symbolsize;
    }

    public void setSymbolsize(Integer symbolsize) {
        this.symbolsize = symbolsize;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}