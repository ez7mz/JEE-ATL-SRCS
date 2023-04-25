package me.ez7mz.atl1jee;

public class Registration {
    private Student student;
    private String regDate;
    private String filier;
    private String group;
    private String niveau;

    public Registration(){}

    public Registration(Student student, String regDate, String filier, String group, String niveau) {
        this.student = student;
        this.regDate = regDate;
        this.filier = filier;
        this.group = group;
        this.niveau = niveau;
    }

    public Student getStudent() {
        return student;
    }

    public String getRegDate(){
        return this.regDate;
    }

    public String getFilier(){
        return this.filier;
    }

    public String getGroup(){
        return this.group;
    }

    public String getNiveau(){
        return this.niveau;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setFilier(String filier) {
        this.filier = filier;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "student=" + student +
                ", regDate='" + regDate + '\'' +
                ", filier='" + filier + '\'' +
                ", group='" + group + '\'' +
                ", niveau='" + niveau + '\'' +
                '}';
    }
}
