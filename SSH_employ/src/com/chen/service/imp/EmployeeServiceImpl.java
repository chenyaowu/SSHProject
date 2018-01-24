package com.chen.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.EmployeeDao;
import com.chen.domain.Employee;
import com.chen.domain.PageBean;
import com.chen.service.EmployeeService;
/*
 * Ա�������ҵ���ʵ����
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	
	/*
	 ҵ���ĵ�¼����
	 */
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage-1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee employee =  employeeDao.findById(eid);
		return employee;
	}

	@Override
	//ҵ����޸�Ա������
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}

	
	
}
