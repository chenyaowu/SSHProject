package com.chen.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * 部门实体
 */
public class Department {
	private Integer did;//id
	private String dname;//部门名称
	private String ddesc;//部门描述
	//员工集合
	private Set<Employee> employee = new HashSet<Employee>();
	
	
//	public Department() {
//	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
	
}
