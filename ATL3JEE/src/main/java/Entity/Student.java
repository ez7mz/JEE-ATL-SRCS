package Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "Nom")
    private String nom;
    @Basic
    @Column(name = "Prénom")
    private String prenom;
    @Basic
    @Column(name = "Date de naissance")
    private Date dateDeNaissance;
    @Basic
    @Column(name = "CIN")
    private String cin;
    @Basic
    @Column(name = "Numéro de téléphone")
    private String numeroDeTelephone;
    @Basic
    @Column(name = "Adresse email")
    private String adresseEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (nom != null ? !nom.equals(student.nom) : student.nom != null) return false;
        if (prenom != null ? !prenom.equals(student.prenom) : student.prenom != null) return false;
        if (dateDeNaissance != null ? !dateDeNaissance.equals(student.dateDeNaissance) : student.dateDeNaissance != null)
            return false;
        if (cin != null ? !cin.equals(student.cin) : student.cin != null) return false;
        if (numeroDeTelephone != null ? !numeroDeTelephone.equals(student.numeroDeTelephone) : student.numeroDeTelephone != null)
            return false;
        if (adresseEmail != null ? !adresseEmail.equals(student.adresseEmail) : student.adresseEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (dateDeNaissance != null ? dateDeNaissance.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        result = 31 * result + (numeroDeTelephone != null ? numeroDeTelephone.hashCode() : 0);
        result = 31 * result + (adresseEmail != null ? adresseEmail.hashCode() : 0);
        return result;
    }
}
