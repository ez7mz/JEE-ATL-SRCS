import Entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.sql.Date;

@Stateless
public class StudentRegistrationBean implements StudentRegistration {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void registerStudent(String nom, String prenom, Date dateDeNaissance, String cin, String numeroDeTelephone, String adresseEmail) {
        Student student = new Student();
        student.setNom(nom);
        student.setPrenom(prenom);
        student.setDateDeNaissance(dateDeNaissance);
        student.setCin(cin);
        student.setNumeroDeTelephone(numeroDeTelephone);
        student.setAdresseEmail(adresseEmail);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entityManager.merge(student));
        transaction.commit();
    }


    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }
}
