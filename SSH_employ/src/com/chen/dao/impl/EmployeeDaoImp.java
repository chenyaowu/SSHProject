package com.chen.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chen.dao.EmployeeDao;
import com.chen.domain.Employee;
/*
 * 员工管理Dao的实现类
 */
public class EmployeeDaoImp extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/*
	Dao中根据用户名和密码查询用户的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username= ? and password= ? ";
		HibernateTemplate hibernateTemplate= this.getHibernateTemplate();
		
		List<Employee> list = hibernateTemplate.find(hql,employee.getUsername(),employee.getPassword());
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Employee";
		List<Long> list =  this.getHibernateTemplate().find(hql);
		if(list.size()>0)
			return list.get(0).intValue();
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
		return this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
		
	}

	

}
