package com.cdtu.bean;

import java.io.Serializable;

public class Employee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer empid;

    private String empname;

    private String empemail;

    private String empaddr;

    private Integer empdepid;
    
    private Department department;

    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empname, String empemail, String empaddr, Integer empdepid) {
		super();
		this.empname = empname;
		this.empemail = empemail;
		this.empaddr = empaddr;
		this.empdepid = empdepid;
	}

	public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail == null ? null : empemail.trim();
    }

    public String getEmpaddr() {
        return empaddr;
    }

    public void setEmpaddr(String empaddr) {
        this.empaddr = empaddr == null ? null : empaddr.trim();
    }

    public Integer getEmpdepid() {
        return empdepid;
    }

    public void setEmpdepid(Integer empdepid) {
        this.empdepid = empdepid;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + ", empaddr=" + empaddr
				+ ", empdepid=" + empdepid + ", department=" + department + "]";
	}
	
}