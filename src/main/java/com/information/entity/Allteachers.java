package com.information.entity;

public class Allteachers {
    private String teid;

    private String id;

    private String teName;

    private String school;

    private String teNum;

    private String teTitle;

    private String department;

    private String teTelephone;

    private String email;

    private String postcode;

    private String teIdentity;

    private String major;

    private String awards;

    private String achievements;

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards == null ? null : awards.trim();
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements == null ? null : achievements.trim();
    }

    public Allteachers(String teid, String teName, String school, String teNum, String teTitle,
                       String department, String teTelephone, String email, String postcode,
                       String teIdentity, String major, String awards, String achievements) {
        this.teid=teid;
               this.teName = teName;
               this.school = school;
               this.teNum = teNum;
               this.teTitle = teTitle;
               this.department = department;

               this.teTelephone = teTelephone;
               this.email = email;
               this.postcode = postcode;
               this.teIdentity = teIdentity;
               this.major = major;
//
//               this.awards = awards;
//               this.achievements = achievements;
    }

    public Allteachers() {

    }

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

    public String getTeName() {
        return teName;
    }

    public void setTeName(String teName) {
        this.teName = teName == null ? null : teName.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getTeNum() {
        return teNum;
    }

    public void setTeNum(String teNum) {
        this.teNum = teNum == null ? null : teNum.trim();
    }

    public String getTeTitle() {
        return teTitle;
    }

    public void setTeTitle(String teTitle) {
        this.teTitle = teTitle == null ? null : teTitle.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getTeIdentity() {
        return teIdentity;
    }

    public void setTeIdentity(String teIdentity) {
        this.teIdentity = teIdentity == null ? null : teIdentity.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }
}