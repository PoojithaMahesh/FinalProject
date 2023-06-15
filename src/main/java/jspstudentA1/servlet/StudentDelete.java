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

@WebServlet("/delete")
public class StudentDelete extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
StudentDao dao=new StudentDao();
dao.deleteStudentById(id);

List<Student> students=dao.getAllStudent();
req.setAttribute("list", students);
RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
dispatcher.forward(req, resp);

}
}
