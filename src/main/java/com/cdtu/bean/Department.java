package com.cdtu.bean;

import java.io.Serializable;

public class Department implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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