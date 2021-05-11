package sample;

import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    private  AnchorPane anchor_right,anchor_top,anchor_main;
    @FXML
    private  TextField name,department,id,email,level,term,phone,hall,remove_text_field,password_text;
    @FXML
    private  TextArea adress;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    public void Show_student_on_action(ActionEvent actionEvent) throws IOException, SQLException {
        Parent pane=FXMLLoader.load( getClass().getResource("Show_student.fxml"));
        anchor_right.getChildren().setAll(pane);

    }

    public void add_student_on_action(ActionEvent actionEvent) throws IOException {
        Parent pane=FXMLLoader.load( getClass().getResource("add_student.fxml"));
        anchor_right.getChildren().setAll(pane);


    }

    public void Remove_Stuedent_on_action(ActionEvent actionEvent) throws IOException {
        Parent pane=FXMLLoader.load( getClass().getResource("remove.fxml"));
        anchor_right.getChildren().setAll(pane);

    }

    public void add_on_action(ActionEvent actionEvent) throws SQLException {
        String name1=name.getText();
        String department1=department.getText();
        String id1=id.getText();
        String email1=email.getText();
        String level1=level.getText();
        String term1=term.getText();
        String phone1=phone.getText();
        String hall1=hall.getText();
        String adress1=adress.getText();
        String password1=password_text.getText();
        if(name1.equals("")||department1.equals("")||id1.equals("")||email1.equals("")||level1.equals("")||term1.equals("")||phone1.equals("")||adress1.equals("")||hall1.equals("")||password1.equals(""))
        {
            System.out.println("fill the row");
            return;
        }
        student std=new student(name1,department1,email1,hall1,adress1,phone1,level1,term1,id1,password1);
        //database
        database db=new database();
        db.add(std);
        name.clear();id.clear();department.clear();email.clear();level.clear();term.clear();phone.clear();hall.clear();adress.clear();password_text.clear();


    }

    public void remove_on_action(ActionEvent actionEvent) throws SQLException {
        database db=new database();
        db.delete(remove_text_field.getText());
        remove_text_field.clear();
    }

    public void Reset_on_action(ActionEvent actionEvent) {
        name.clear();id.clear();department.clear();email.clear();level.clear();term.clear();phone.clear();hall.clear();adress.clear();password_text.clear();
    }
}
