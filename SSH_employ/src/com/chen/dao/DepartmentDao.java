package com.chen.dao;

import java.util.List;

import com.chen.domain.Department;

/*
 * 部门DAO接口
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
