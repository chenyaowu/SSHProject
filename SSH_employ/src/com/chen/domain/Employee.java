package com.chen.domain;

import java.util.Date;

/*
 * Ա��ʵ��
 */
public class Employee {
	private Integer eid;//id
	private String ename;//����
	private String sex;//�Ա�
	private Date birthday;//����
	private Date jointDate;//��ְ����
	private String eno;//Ա�����
	private String username;//�˻���
	private String password;//�˻�����
	private Department department = new Department();//��������
	
	
//	public Employee() {
//		
//	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJointDate() {
		return jointDate;
	}
	public void setJointDate(Date jointDate) {
		this.jointDate = jointDate;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
}
