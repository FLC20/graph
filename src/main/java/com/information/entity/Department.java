package com.information.entity;

public class Department {
    private String deid;

    private String id;

    private String dename;

    private String detime;

    public Department(String deid, String dename, String defrom, String detime,
                      String delevel, String deawards) {
        this.deid=deid;
        this.dename=dename;
        this.detime=detime;

    }

    public String getDeid() {
        return deid;
    }

    public void setDeid(String deid) {
        this.deid = deid == null ? null : deid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename == null ? null : dename.trim();
    }

    public String getDetime() {
        return detime;
    }

    public void setDetime(String detime) {
        this.detime = detime == null ? null : detime.trim();
    }
}