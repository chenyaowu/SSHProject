package com.chen.action;

import com.chen.domain.Department;
import com.chen.domain.PageBean;
import com.chen.service.DepartmentService;
import com.chen.service.imp.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * ���Ź����Action��
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//ģ����������
	private Department Department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return Department;
	}
	//��ǰҳ
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//ע��DepartmentService
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	public String findAll(){
		PageBean<Department> pageBean= departmentService.findByPag(currPage);
		//��pageBean���뵽ֵջ��
		
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		return "saveUI";
	}
	
	//��Ӳ���ִ�еķ���
	public String save(){
		departmentService.save(Department);
		return "savesuccess";
	}
	public String edit(){
		Department = departmentService.findById(Department.getDid());
		return "editSuccess";
	}
	
	public String update(){
		departmentService.update(Department);
		return "updateSuccess";
	}
	public String delete(){
		Department department = departmentService.findById(Department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
