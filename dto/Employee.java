package com.cg.dto;

public class Employee 
{
	int empId;
	String empname;
	int empsal;
	String empAddr;
	
	public Employee()
	{
		
	}
	
	public Employee(int empId, String empname, int empsal, String empAddr) 
	{
		super();
		this.empId = empId;
		this.empname = empname;
		this.empsal = empsal;
		this.empAddr = empAddr;
	}

	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empname=" + empname
				+ ", empsal=" + empsal + ", empAddr=" + empAddr + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpsal() {
		return empsal;
	}

	public void setEmpsal(int empsal) {
		this.empsal = empsal;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
		

}
