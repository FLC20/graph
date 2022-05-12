package com.information.entity;

public class Tea2schKey {
    private String startId;

    private String endId;

    public String getStartId() {
        return startId;
    }

    public void setStartId(String startId) {
        this.startId = startId == null ? null : startId.trim();
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId == null ? null : endId.trim();
    }
}