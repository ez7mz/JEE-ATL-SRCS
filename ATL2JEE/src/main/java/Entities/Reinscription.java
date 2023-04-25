package Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reinscription")
public class Reinscription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "regdate")
    private Date regdate;
    @Basic
    @Column(name = "groupe")
    private String groupe;
    @Basic
    @Column(name = "niveau")
    private String niveau;
    @Basic
    @Column(name = "cycle")
    private String cycle;
    @Basic
    @Column(name = "etudiant_id")
    private Integer etudiantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Etudiant etudiantByEtudiantId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Integer etudiantId) {
        this.etudiantId = etudiantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reinscription that = (Reinscription) o;

        if (id != that.id) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;
        if (groupe != null ? !groupe.equals(that.groupe) : that.groupe != null) return false;
        if (niveau != null ? !niveau.equals(that.niveau) : that.niveau != null) return false;
        if (cycle != null ? !cycle.equals(that.cycle) : that.cycle != null) return false;
        if (etudiantId != null ? !etudiantId.equals(that.etudiantId) : that.etudiantId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (niveau != null ? niveau.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        result = 31 * result + (etudiantId != null ? etudiantId.hashCode() : 0);
        return result;
    }

    public Etudiant getEtudiantByEtudiantId() {
        return etudiantByEtudiantId;
    }

    public void setEtudiantByEtudiantId(Etudiant etudiantByEtudiantId) {
        this.etudiantByEtudiantId = etudiantByEtudiantId;
    }

    @Override
    public String toString() {
        return "Reinscription{" +
                "id=" + id +
                ", regdate=" + regdate +
                ", groupe='" + groupe + '\'' +
                ", niveau='" + niveau + '\'' +
                ", cycle='" + cycle + '\'' +
                ", etudiantId=" + etudiantId +
                '}';
    }
}
