package com.information.entity;

public class Schools {
    private String scid;

    private String id;

    private String scname;

    private String scplace;

    private String sctype;

    private String sctime;

    private String schoolMotto;

    private String schoolSpirit;

    private String teachingStyle;

    private String styleOfStudy;

    public Schools(String id, String scid, String scname, String scplace, String sctype, String sctime, String schoolMotto, String schoolSpirit, String teachingStyle, String styleOfStudy) {
        this.id=id;
        this.scid=scid;
        this.scname=scname;
        this.scplace=scplace;
        this.sctype=sctype;
        this.sctime=sctime;
        this.schoolMotto=schoolMotto;
        this.schoolSpirit=schoolSpirit;
        this.teachingStyle=teachingStyle;
        this.styleOfStudy=styleOfStudy;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid == null ? null : scid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname == null ? null : scname.trim();
    }

    public String getScplace() {
        return scplace;
    }

    public void setScplace(String scplace) {
        this.scplace = scplace == null ? null : scplace.trim();
    }

    public String getSctype() {
        return sctype;
    }

    public void setSctype(String sctype) {
        this.sctype = sctype == null ? null : sctype.trim();
    }

    public String getSctime() {
        return sctime;
    }

    public void setSctime(String sctime) {
        this.sctime = sctime == null ? null : sctime.trim();
    }

    public String getSchoolMotto() {
        return schoolMotto;
    }

    public void setSchoolMotto(String schoolMotto) {
        this.schoolMotto = schoolMotto == null ? null : schoolMotto.trim();
    }

    public String getSchoolSpirit() {
        return schoolSpirit;
    }

    public void setSchoolSpirit(String schoolSpirit) {
        this.schoolSpirit = schoolSpirit == null ? null : schoolSpirit.trim();
    }

    public String getTeachingStyle() {
        return teachingStyle;
    }

    public void setTeachingStyle(String teachingStyle) {
        this.teachingStyle = teachingStyle == null ? null : teachingStyle.trim();
    }

    public String getStyleOfStudy() {
        return styleOfStudy;
    }

    public void setStyleOfStudy(String styleOfStudy) {
        this.styleOfStudy = styleOfStudy == null ? null : styleOfStudy.trim();
    }
}