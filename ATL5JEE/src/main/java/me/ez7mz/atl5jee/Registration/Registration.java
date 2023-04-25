package me.ez7mz.atl5jee.Registration;


import jakarta.persistence.*;
import me.ez7mz.atl5jee.Student.Student;

import java.time.LocalDate;

@Entity(name = "registration")
@Table
public class Registration {

    @Id
    @SequenceGenerator(name = "registration_sequence", sequenceName = "registration_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "cycle", nullable = false)
    private String cycle;

    @Column(name = "filier", nullable = false)
    private String filier;

    @Column(name = "regdate", nullable = false)
    private String regdate;

    @Column(name = "student_id", nullable = false, updatable = false)
    private Long studentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public Registration() {
    }

    public Registration(String cycle, String filier, String regdate, Long studentId, Student etudiantByEtudiantId) {
        this.cycle = cycle;
        this.filier = filier;
        this.regdate = regdate;
        this.studentId = studentId;
    }

    public Registration(Long id, String cycle, String filier, String regdate, Long studentId) {
        this.id = id;
        this.cycle = cycle;
        this.filier = filier;
        this.regdate = regdate;
        this.studentId = studentId;
    }

    public Registration(String cycle, String filier, String regdate, Student student) {
        this.cycle = cycle;
        this.filier = filier;
        this.regdate = regdate;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getFilier() {
        return filier;
    }

    public void setFilier(String filier) {
        this.filier = filier;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", cycle='" + cycle + '\'' +
                ", filier='" + filier + '\'' +
                ", regdate=" + regdate +
                ", studentId=" + studentId +
                ", student=" + student +
                '}';
    }
}
