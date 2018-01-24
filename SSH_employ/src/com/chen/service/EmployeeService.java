package com.chen.service;
/*
 * Ա������ҵ���ӿ�
 */

import com.chen.domain.Employee;
import com.chen.domain.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);


	void delete(Employee employee);

}
