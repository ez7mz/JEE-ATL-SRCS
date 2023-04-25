package me.ez7mz.atl1jee;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setDate(request.getParameter("date"));
        student.setCin(request.getParameter("cin"));
        student.setPhone(request.getParameter("phone"));
        student.setAddress(request.getParameter("address"));
        student.setEmail(request.getParameter("email"));

        Registration reg = new Registration();
        reg.setStudent(student);
        reg.setRegDate(request.getParameter("regDate"));
        reg.setFilier(request.getParameter("filier"));
        reg.setGroup(request.getParameter("group"));
        reg.setNiveau(request.getParameter("niveau"));

        student.Register();

        request.setAttribute("student", reg.getStudent());
        request.setAttribute("regDate", reg.getRegDate());
        request.setAttribute("filier", reg.getFilier());
        request.setAttribute("group", reg.getGroup());
        request.setAttribute("niveau", reg.getNiveau());

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
        doGet(request, response);
    }

    public void destroy() {
    }
}