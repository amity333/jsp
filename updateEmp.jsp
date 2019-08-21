<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="EmployeeServlet?action=update" method="post">
<label>Employee Id</label>
<input type="text" name="eId" value ="${updById.empId }"/><br>

<label>Employee Name</label>
<input type="text" name="eName" value ="${updById.empname }"/><br>

<label>Employee Address</label>
<input type="text" name="addr" value ="${updById.empAddr }"/><br>

<label>Employee Salary</label>
<input type="text" name="eSal" value ="${updById.empsal }"/><br>

<button type="submit">Submit</button>
</form>

</body>
</html>