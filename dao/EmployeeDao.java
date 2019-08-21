package com.cg.dao;

import java.util.ArrayList;

import com.cg.dto.Employee;

public interface EmployeeDao 
{
	public Employee addEmployee(Employee emp);
	
	public Employee getEmployeeById(int empId);
	
	public ArrayList<Employee> getAllEmployees();
	
	public void deleteEmployee(int empId);
	
	public void updateEmployee(Employee emp);

}
