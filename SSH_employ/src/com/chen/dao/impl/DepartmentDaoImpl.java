package com.chen.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chen.dao.DepartmentDao;
import com.chen.domain.Department;
/*
 * 部门DAO实现类
 */ 
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	/*
	 * 查询数据条数
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
			return list.get(0).intValue();
		return 0;
	}

	@Override
	/*
	 * 分页查询部门
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		return list;
	}

	@Override
	/*
	 * Dao中保存部门的方法
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		 List<Department> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	

}
