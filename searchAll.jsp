<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<caption>Employee Details</caption>
<tr>
<th>EmpId</th>
<th>EmpName</th>
<th>EmpSalary</th>
<th>EmpAddress</th>
</tr>

<c:forEach items="${emplist }" var="emp">
<tr>
   <td><c:out value="${emp.empId }"></c:out></td>
    <td><c:out value="${emp.empname }"></c:out></td>
     <td><c:out value="${emp.empsal }"></c:out></td>
      <td><c:out value="${emp.empAddr }"></c:out></td>
      <td><a href="EmployeeServlet?action=deleteEmp&id=${emp.empId }">Delete</a></td>
       <td><a href="EmployeeServlet?action=updateEmp&id=${emp.empId }">Update</a></td>
</tr>

</c:forEach>
</table>

</body>
</html>