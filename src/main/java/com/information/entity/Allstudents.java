package com.information.entity;

public class Allstudents {
    private String stid;

    private String id;

    private String stuname;

    private String stunum;

    private String sex;

    private String age;

    private String nation;

    private String political;

    private String telephone;

    private String lauguageAbility;

    private String major;

    private String place;

    private String school;

    public Allstudents(String stid, String id, String stuname, String stunum, String sex,
                       String age, String nation, String political, String telephone,
                       String lauguageAbility, String major, String place, String school) {

        this.age=age;
        this.id=id;
        this.lauguageAbility=lauguageAbility;
        this.major=major;
        this.nation=nation;
        this.place=place;
        this.political=political;
        this.school=school;
        this.sex=sex;
        this.stid=stid;
        this.stuname=stuname;
        this.stunum=stunum;
        this.telephone=telephone;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum == null ? null : stunum.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getLauguageAbility() {
        return lauguageAbility;
    }

    public void setLauguageAbility(String lauguageAbility) {
        this.lauguageAbility = lauguageAbility == null ? null : lauguageAbility.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
}