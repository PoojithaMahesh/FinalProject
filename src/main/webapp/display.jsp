<%@page import="jspstudentA1.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Student> students=(List)request.getAttribute("list"); %>
<table border="2px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>Phone</th>
<th>Fees</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%for(Student student:students) {%>
<tr>
<td><%=student.getStudentId() %></td>
<td><%=student.getStudentName() %></td>
<td><%=student.getStudentEmail() %></td>
<td><%=student.getStudentPassword() %></td>
<td><%=student.getStudentAddress() %></td>

<td><%=student.getStudentPhone() %></td>
<td><%=student.getStudentFees() %></td>
<td><a href="delete?id=<%=student.getStudentId() %>">Delete</a></td>
<td><a href="update?id=<%=student.getStudentId() %>">Update</a></td>
</tr>

<%} %>


</table>
</body>
</html>