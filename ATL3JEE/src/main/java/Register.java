import java.io.*;
import java.sql.Date;

import Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setNom(request.getParameter("lname"));
        student.setPrenom(request.getParameter("fname"));
        student.setCin(request.getParameter("cin"));
        student.setAdresseEmail(request.getParameter("email"));
        student.setDateDeNaissance(Date.valueOf(request.getParameter("date")));
        student.setNumeroDeTelephone(request.getParameter("phone"));

        request.setAttribute("student", student);

        StudentRegistrationBean jpa = new StudentRegistrationBean();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        jpa.entityManager = entityManager;
        jpa.registerStudent(student.getNom(), student.getPrenom(), student.getDateDeNaissance(), student.getCin()
                , student.getNumeroDeTelephone(), student.getAdresseEmail());
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
        doGet(request, response);
    }

    public void destroy() {
    }
}