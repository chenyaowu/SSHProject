package com.chen.service;

import java.util.List;

import com.chen.domain.Department;
import com.chen.domain.PageBean;

/*
 * 部门管理的业务层的接口
 */
public interface DepartmentService {

	PageBean<com.chen.domain.Department> findByPag(Integer currPage);

	void save(com.chen.domain.Department department);

	Department findById(Integer did);

	void update(com.chen.domain.Department department);

	void delete(com.chen.domain.Department department);

	List<Department> findAll();


}
