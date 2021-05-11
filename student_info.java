package sample;

public class student_info {
    private String name, college, password, email, nationality, city;

    public student_info(String name, String college, String password, String email, String nationality, String city) {
        this.name = name;
        this.college = college;
        this.password = password;
        this.email = email;
        this.nationality = nationality;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
