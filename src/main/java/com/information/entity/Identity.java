package com.information.entity;

public class Identity {
    private String ideid;

    private String id;

    private String idname;

    public String getIdeid() {
        return ideid;
    }

    public void setIdeid(String ideid) {
        this.ideid = ideid == null ? null : ideid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname == null ? null : idname.trim();
    }
}