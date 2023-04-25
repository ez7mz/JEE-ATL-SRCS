import Entity.Student;
import jakarta.ejb.Remote;

import java.sql.Date;

@Remote
public interface StudentRegistration {
    void registerStudent(String nom, String prenom, Date dateDeNaissance, String cin, String numeroDeTelephone, String adresseEmail);
    Student getStudent(int id);
}
