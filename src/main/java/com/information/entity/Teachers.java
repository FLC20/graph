package com.information.entity;

public class Teachers {
    private String teid;

    private String id;

    private String name;

    private String tenum;

    private String teTitle;

    private String teTelephone;

    private String email;

    private String direction;

    private String postcode;

    public String getTeid() {
        return teid;
    }

    public void setTeid(String teid) {
        this.teid = teid == null ? null : teid.trim();
    }

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

    public String getTenum() {
        return tenum;
    }

    public void setTenum(String tenum) {
        this.tenum = tenum == null ? null : tenum.trim();
    }

    public String getTeTitle() {
        return teTitle;
    }

    public void setTeTitle(String teTitle) {
        this.teTitle = teTitle == null ? null : teTitle.trim();
    }

    public String getTeTelephone() {
        return teTelephone;
    }

    public void setTeTelephone(String teTelephone) {
        this.teTelephone = teTelephone == null ? null : teTelephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }
}