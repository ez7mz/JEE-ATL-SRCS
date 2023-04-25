import Entities.Etudiant;
import Entities.Reinscription;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.mapping.Join;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static void createThreeStudent(EntityManager entityManager){
        Etudiant first = new Etudiant();
        first.setNom("Mesrar");
        first.setPrenom("Hamza");
        first.setCin("USA481516");

        Etudiant second = new Etudiant();
        second.setNom("Nabouzi");
        second.setPrenom("Yasser");
        second.setCin("USA786523");

        Etudiant third = new Etudiant();
        third.setNom("Shady");
        third.setPrenom("Slim");
        third.setCin("USA201532");

        entityManager.persist(entityManager.merge(first));
        entityManager.persist(entityManager.merge(second));
        entityManager.persist(entityManager.merge(third));
    }

    static void printAllStudents(EntityManager entityManager){
        List<Etudiant> students = entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
        for (Etudiant student : students) {
            System.out.println(student.toString());
            System.out.println("-------------------------");
        }
    }

    static void printRegOfStudent(EntityManager entityManager, int id){
        Etudiant student = entityManager.find(Etudiant.class, id);

        List<Reinscription> reinscriptions = student.getReinscription();
        for (Reinscription reinscription : reinscriptions) {
            System.out.println(reinscription.toString());
            System.out.println("-------------------------");
        }
    }

    static void creatReg(EntityManager entityManager, int id)
    {
        Reinscription reg = new Reinscription();
        reg.setRegdate(Date.valueOf("2023-03-17"));
        reg.setGroupe("Grp4");
        reg.setCycle("GI");
        reg.setNiveau("3eme");
        reg.setEtudiantId(id);
        reg.setEtudiantByEtudiantId(entityManager.find(Etudiant.class, id));

        entityManager.persist(entityManager.merge(reg));
    }

    static void deleteStudent(EntityManager entityManager, int id){
        Etudiant student = entityManager.find(Etudiant.class, id);
        entityManager.remove(student);

        System.out.println("The student with ID "+id+" has been deleted.");
    }

    static void modifyStudent(EntityManager entityManager, int id)
    {
        Etudiant student = entityManager.find(Etudiant.class, id);
        student.setPrenom("EZ");
        System.out.println("Student with ID "+id+" has been updated.");
    }

    static void printStudentInLvl(EntityManager entityManager, String Lvl){
        TypedQuery<Etudiant> query = entityManager.createQuery("SELECT DISTINCT a FROM Etudiant a JOIN a.reg b WHERE b.niveau = :Lvl", Etudiant.class);
        query.setParameter("Lvl", Lvl);

        List<Etudiant> students = query.getResultList();

        System.out.println("Etudiants dont le niveau est en 3ème année:");
        for (Etudiant student : students) {
            System.out.println(student.toString());
        }
    }
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//             Question 1 : Créer trois étudiants.
//            createThreeStudent(entityManager);

            // Question 2 : Afficher la liste des étudiants.
//            printAllStudents(entityManager);

            // Question 3 : Afficher les réinscriptions de l'étudiant dont id = 44.
//            creatReg(entityManager, 25);
//            printRegOfStudent(entityManager, 23);
            // Question 4 : Supprimer l'étudiant dont id = 60.
//            deleteStudent(entityManager, 25);
            // Question 5 : Modifier les informations d'étudiant dont id = 88
//            modifyStudent(entityManager, 23);
            // Question 6 : - Afficher la liste des étudiants dont le niveau est en 3ème année.
            printStudentInLvl(entityManager, "4eme");
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
