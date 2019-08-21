package com.cg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.dto.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;

/**
 * Servlet implementation class employeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        service = new EmployeeServiceImpl();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String qStr = request.getParameter("action");
		
		if("insert".equals(qStr))
		{
			RequestDispatcher dispatch  = request.getRequestDispatcher("insert.jsp");
			dispatch.forward(request, response);
		}
		else if("displayById".equals(qStr))
		{
			RequestDispatcher dispatch =  request.getRequestDispatcher("searchById.jsp");
			dispatch.forward(request, response);
			
		}
		
		else if("displayAll".equals(qStr))
		{
			ArrayList<Employee> list = service.getAllEmployees();
			session.setAttribute("emplist", list);
			RequestDispatcher dispatch =  request.getRequestDispatcher("searchAll.jsp");
			dispatch.forward(request, response);
		}
		else if("deleteEmp".equals(qStr))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			service.deleteEmployee(id);
			ArrayList<Employee> list=service.getAllEmployees();
			session.setAttribute("emplist", list);
			RequestDispatcher dispatch = 
					request.getRequestDispatcher("searchAll.jsp");
			dispatch.forward(request, response);
			
		}
		else if("updateEmp".equals(qStr))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			Employee emp = service.getEmployeeById(id);
			
			session.setAttribute("updById", emp);
			RequestDispatcher dispatch = 
					request.getRequestDispatcher("updateEmp.jsp");
			dispatch.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String qStr = request.getParameter("action");
		if("insertEmp".equals(qStr))
		{
			String name = request.getParameter("eName");
			String addr = request.getParameter("addr");
			String sal = request.getParameter("eSal");
			int eSal = Integer.parseInt(sal);
			Employee emp = new Employee();
			emp.setEmpname(name);
			emp.setEmpsal(eSal);
			emp.setEmpAddr(addr);
			Employee ref = service.addEmployee(emp);
			if(ref!=null)
			{
				session.setAttribute("emp", ref);
				RequestDispatcher dispatch  =request.getRequestDispatcher("insertSuccess.jsp");
				dispatch.forward(request, response);
			}
		}
			else if("searchById".equals(qStr))
			{
				String empId = request.getParameter("id");
				int eId = Integer.parseInt(empId);
				Employee emp = service.getEmployeeById(eId);
				session.setAttribute("empById", emp);
				RequestDispatcher dispatch = 
						request.getRequestDispatcher("success.jsp");
				dispatch.forward(request, response);
			}
		
			else if("update".equals(qStr))
			{
				int id = Integer.parseInt(request.getParameter("eId"));
				String name = request.getParameter("eName");
				String addr = request.getParameter("addr");
				String sal = request.getParameter("eSal");
				int eSal = Integer.parseInt(sal);
				Employee emp = new Employee();
				emp.setEmpId(id);
				emp.setEmpname(name);
				emp.setEmpsal(eSal);
				emp.setEmpAddr(addr);
				System.out.println(emp.toString());
				service.updateEmployee(emp);
				//System.out.println(emp.toString());
				ArrayList<Employee> list=service.getAllEmployees();
					session.setAttribute("emplist", list);
					RequestDispatcher dispatch  =request.getRequestDispatcher("searchAll.jsp");
					dispatch.forward(request, response);
			}
		
		
		
	}

}
