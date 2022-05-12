package com.information.entity;

public class Major {
    private String maid;

    private String id;

    private String majname;

    public Major(String id, String maid, String majname) {
        this.id=id;
        this.maid=maid;
        this.majname=majname;
    }

    public String getMaid() {
        return maid;
    }

    public void setMaid(String maid) {
        this.maid = maid == null ? null : maid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMajname() {
        return majname;
    }

    public void setMajname(String majname) {
        this.majname = majname == null ? null : majname.trim();
    }
}