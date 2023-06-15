package jspstudentA1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudentA1.dao.StudentDao;
import jspstudentA1.dto.Student;

@WebServlet("/login")
public class StudentLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		List<Student> students = dao.getAllStudent();

		boolean value = false;
		for (Student student : students) {
			if (student.getStudentEmail().equals(email)) {
				value = true;
				break;
			}
		}
//when it is going to give this
//false=when that email is not at all present in the database
//true=when that email is present in the database
		if (value) {
//	check with password
// first fetch the student based on the email
			Student student = dao.getStudentByEmail(email);
			if (student.getStudentPassword().equals(password)) {
//    	login success 
				req.setAttribute("list", students);
				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			} else {
//    	login failure because of wrong password
				req.setAttribute("message", "Wrong password /n Please enter a valid password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}

		} else {
//	give a msg that email is not present email doesnot exist
//	i need show the same login page
			req.setAttribute("message", "EMAILDOESNOTEXIST");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}
}
