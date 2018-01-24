package com.chen.action;

import java.util.List;

import com.chen.domain.Department;
import com.chen.domain.Employee;
import com.chen.domain.PageBean;
import com.chen.service.DepartmentService;
import com.chen.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 员工管理的Action类
 */
public class EmployAction extends ActionSupport implements ModelDriven<Employee>{

	//模型驱动使用的对象
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入业务层类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}





	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	//登录执行的方法
	public String login(){
		System.out.println("login");
		//调用业务层的类
		Employee existEmployee =  employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
		
	}
	
	//接收当前页数
	private Integer currPage =1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}



	public String findAll(){
		PageBean<Employee> pageBean =  employeeService.findByPage(currPage);
		System.out.println(pageBean.getList().size());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
		
	}
	
	public String save(){
		System.out.println("aaaaaaaaaaaaaaa"+employee.getDepartment());
		employeeService.save(employee);
		
		return "saveSuccess";
	}
	
	public String edit(){
		employee =  employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
		
	}
	
}
