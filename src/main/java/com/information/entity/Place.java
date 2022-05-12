package com.information.entity;

public class Place {
    private String plid;

    private String id;

    private String plname;

    public Place(String id, String plid, String plname) {
        this.id=id;
        this.plid=plid;
        this.plname=plname;
    }

    public String getPlid() {
        return plid;
    }

    public void setPlid(String plid) {
        this.plid = plid == null ? null : plid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlname() {
        return plname;
    }

    public void setPlname(String plname) {
        this.plname = plname == null ? null : plname.trim();
    }
}