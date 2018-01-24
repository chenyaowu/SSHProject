package com.chen.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chen.dao.DepartmentDao;
import com.chen.domain.Department;
import com.chen.domain.PageBean;
import com.chen.service.DepartmentService;
/*
 * ���Ź����ҵ����ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//ע��Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	@Override
	/*
	 * ��ҳ��ѯ���ŵķ���
	 */
	public PageBean<Department> findByPag(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��Ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ����
		int begin = (currPage -1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	/*
	 * ҵ��㱣�沿�ŵķ���
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		
		
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	
	
}
