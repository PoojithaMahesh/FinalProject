package jspstudentA1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspstudentA1.dao.StudentDao;
import jspstudentA1.dto.Student;

@WebServlet("/update")
public class StudentUpdate extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));

StudentDao  dao=new StudentDao();
Student  student=dao.getStudentById(id);


req.setAttribute("student", student);
RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
dispatcher.forward(req, resp);

}
}
