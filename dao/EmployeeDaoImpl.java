package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.ResultSet;

import com.cg.dto.Employee;
import com.cg.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao
{
	Connection con;
	
	public EmployeeDaoImpl()
	{
		con = DBUtil.getConnection();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		Employee ref = null;
		String qry = "INSERT INTO EmpDetails VALUES(eId_seq.nextval,?,?,?)";
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, emp.getEmpname());
			pstmt.setInt(2, emp.getEmpsal());
			pstmt.setString(3, emp.getEmpAddr());
			
			int row = pstmt.executeUpdate();
			if(row>0)
			{
				emp.setEmpId(getEmployeeId());
				ref = emp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ref;
	}
	
	public int getEmployeeId()
	{
		int id = 0;
		String qry = "SELECT eId_seq.currval FROM DUAL";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		
		Employee ref = null;
		String qry = "SELECT * FROM EmpDetails WHERE empId=?";
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, empId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sal = rs.getInt(3);
				String addr = rs.getString(4);
				ref = new Employee(id,name,sal,addr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ref;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		
		String qry =  "SELECT * FROM EmpDetails";
		ArrayList<Employee> list = new ArrayList<Employee>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sal = rs.getInt(3);
				String addr = rs.getString(4);
				Employee emp = new Employee(id,name,sal,addr);
				list.add(emp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	public void deleteEmployee(int empId) 
	{	
		
		String qry = "DELETE FROM EmpDetails WHERE empId=?";
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, empId);
						
			int row= pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public void updateEmployee(Employee emp)
	{
		String qry = "UPDATE EmpDetails SET empname=?,empsal=?,empAddr=? WHERE empId=?";
		try
		{
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, emp.getEmpname());
			pstmt.setInt(2, emp.getEmpsal());
			pstmt.setString(3, emp.getEmpAddr());
			pstmt.setInt(4, emp.getEmpId());
			
			int row = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
