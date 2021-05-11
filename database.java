package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database {
    Connection getConnection() throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
        return  conn;
    }
        ObservableList<student> getStudent() throws SQLException {
        ObservableList<student> stdlist=FXCollections.observableArrayList();
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        String query ="SELECT * FROM student";
        ResultSet rs =statement.executeQuery(query);
        while (rs.next()) {

            String name=rs.getString("Name");
            String id=rs.getString("ID");
            String department=rs.getString("Department");
            String hall=rs.getString("Hall");
            String level=rs.getString("Level");
            String term=rs.getString("Term");
            String adress=rs.getString("Adress");
            String email=rs.getString("Email");
            String phone=rs.getString("Phone");
            String password=rs.getString("Password");
            student std=new student(name,department,email,hall,adress,phone,level,term,id,password);
            stdlist.add(std);

        }
        return  stdlist;
    }
    void add(student student) throws SQLException {
        Connection conn=getConnection();
        String sql = "insert into student "
                + " (Name, ID, Department,Level,Term,Hall,Phone,Adress,Email,img_name,Password)" + " values (?, ?, ?,?,?,?,?,?,?,?,?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        String img="uj.jpg";

        // set param values
        statement.setString(1, student.getName());
        statement.setString(2, student.getId());
        statement.setString(3, student.getDepartment());
        statement.setString(4, student.getLevel());
        statement.setString(5, student.getTerm());
        statement.setString(6, student.getHall());
        statement.setString(7, student.getPhone());
        statement.setString(8, student.getAdress());
        statement.setString(9, student.getEmail());
        statement.setString(10, img);
        statement.setString(11,student.getPassword());

        // 3. Execute SQL query
        statement.executeUpdate();
    }
    void delete(String std) throws SQLException {
        Connection conn=getConnection();
        String sql ="delete from student where ID = ?";
        PreparedStatement statement=conn.prepareStatement(sql);
        statement.setString(1,std);
        statement.executeUpdate();
    }


}
