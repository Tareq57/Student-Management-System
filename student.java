package sample;

public class student {
    String name,department,email,hall,adress,phone,level,term,id,password;

    public student(String name, String department, String email, String hall, String adress, String phone, String level, String term, String id,String password) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.hall = hall;
        this.adress = adress;
        this.phone = phone;
        this.level = level;
        this.term = term;
        this.id = id;
        this.password=password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public  String getPassword(){return  password;}

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", hall='" + hall + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                ", term='" + term + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
