package com.chen.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * ����ʵ��
 */
public class Department {
	private Integer did;//id
	private String dname;//��������
	private String ddesc;//��������
	//Ա������
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
