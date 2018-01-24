package com.chen.service;

import java.util.List;

import com.chen.domain.Department;
import com.chen.domain.PageBean;

/*
 * ���Ź����ҵ���Ľӿ�
 */
public interface DepartmentService {

	PageBean<com.chen.domain.Department> findByPag(Integer currPage);

	void save(com.chen.domain.Department department);

	Department findById(Integer did);

	void update(com.chen.domain.Department department);

	void delete(com.chen.domain.Department department);

	List<Department> findAll();


}
