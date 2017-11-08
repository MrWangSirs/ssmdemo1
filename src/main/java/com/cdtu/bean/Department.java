package com.cdtu.bean;

public class Department {
    private Integer depid;

    private String depname;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

	@Override
	public String toString() {
		return "Department [depid=" + depid + ", depname=" + depname + "]";
	}
}