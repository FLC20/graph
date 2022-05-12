package com.information.entity;

public class AllteachersWithBLOBs extends Allteachers {
    private String awards;

    private String achievements;

    public AllteachersWithBLOBs(String teid, String teName, String school, String teNum, String teTitle, String department, String teTelephone, String email, String postcode, String teIdentity, String major, String awards, String achievements) {
        super(teid, teName, school, teNum, teTitle, department, teTelephone, email, postcode, teIdentity, major, awards, achievements);



        this.awards=awards;
        this.achievements=achievements;
    }

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
}