package jspstudentA1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudentA1.dao.StudentDao;
import jspstudentA1.dto.Student;

@WebServlet("/edit")
public class StudentEdit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	ServletContext  context=getServletContext();
	String stringfees=context.getInitParameter("fees");
	double fees=Double.parseDouble(stringfees);
	
	
	Student student=new Student();
	student.setStudentAddress(address);
   student.setStudentEmail(email);
   student.setStudentFees(fees);
   student.setStudentName(name);
   student.setStudentPassword(password);
   student.setStudentPhone(phone);
	
	
	StudentDao dao=new StudentDao();
	
	dao.updateStudent(id,student);

	List<Student> students=dao.getAllStudent();
	
	req.setAttribute("list", students);
	RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
	dispatcher.forward(req, resp);
	}
}
