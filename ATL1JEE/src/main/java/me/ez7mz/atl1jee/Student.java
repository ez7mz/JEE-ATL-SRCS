package me.ez7mz.atl1jee;
public class Student {
    private String name;
    private String date;
    private String cin;
    private String phone;
    private String address;
    private String email;

    @Override
    public String toString() {
        return "name=" + name + "\n date=" + date + "\n cin=" + cin + "\n phone=" + phone + "\n address=" + address
                + "\n email=" + email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
        super();
    }

    public void Register() {
        System.out.println("The user that have the name of "+this.name+" is registred seccesfuly!");
    }

}
