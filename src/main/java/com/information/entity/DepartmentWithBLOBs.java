package com.information.entity;

public class DepartmentWithBLOBs extends Department {
    private String defrom;

    private String delevel;

    private String deawards;

    public DepartmentWithBLOBs(String deid, String dename, String defrom, String detime, String delevel, String deawards) {
        super(deid,dename,defrom,detime,delevel,deawards);
        this.deawards=deawards;
        this.defrom=defrom;
        this.delevel=delevel;
    }

    public String getDefrom() {
        return defrom;
    }

    public void setDefrom(String defrom) {
        this.defrom = defrom == null ? null : defrom.trim();
    }

    public String getDelevel() {
        return delevel;
    }

    public void setDelevel(String delevel) {
        this.delevel = delevel == null ? null : delevel.trim();
    }

    public String getDeawards() {
        return deawards;
    }

    public void setDeawards(String deawards) {
        this.deawards = deawards == null ? null : deawards.trim();
    }
}