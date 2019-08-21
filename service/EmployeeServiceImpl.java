package com.cg.service;

import java.util.ArrayList;

import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;
import com.cg.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService
{
	EmployeeDao dao;
	
	public EmployeeServiceImpl()
	{
		dao = new EmployeeDaoImpl();
	}

	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.addEmployee(emp);
	}

	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(empId);
	}

	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	public void deleteEmployee(int empId) {
	dao.deleteEmployee(empId);
		
	}

	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		dao.updateEmployee(emp);
	}

}
