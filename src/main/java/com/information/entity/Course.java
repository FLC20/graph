package com.information.entity;

public class Course {
    private String coid;

    private String id;

    private String coname;

    private String coscore;

    public Course(String coid, String coname, String coscore) {
        this.coid=coid;
        this.coname=coname;
        this.coscore=coscore;
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname == null ? null : coname.trim();
    }

    public String getCoscore() {
        return coscore;
    }

    public void setCoscore(String coscore) {
        this.coscore = coscore == null ? null : coscore.trim();
    }
}