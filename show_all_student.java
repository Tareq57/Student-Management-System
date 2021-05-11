package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class show_all_student implements Initializable {
    @FXML
    TableView<student>table_view;
    @FXML
    TableColumn<student,String>table_name,table_department,table_id,table_level,table_term,table_hall,table_phone,table_adress,table_email;
    ObservableList<student>stdlist= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        database db=new database();
        try {
            stdlist= db.getStudent();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table_name.setCellValueFactory(new PropertyValueFactory<student,String>("name"));
        table_id.setCellValueFactory(new PropertyValueFactory<student,String>("id"));
        table_department.setCellValueFactory(new PropertyValueFactory<student,String>("department"));
        table_level.setCellValueFactory(new PropertyValueFactory<student,String>("level"));
        table_term.setCellValueFactory(new PropertyValueFactory<student,String>("term"));
        table_hall.setCellValueFactory(new PropertyValueFactory<student,String>("hall"));
        table_phone.setCellValueFactory(new PropertyValueFactory<student,String>("phone"));
        table_adress.setCellValueFactory(new PropertyValueFactory<student,String>("adress"));
        table_email.setCellValueFactory(new PropertyValueFactory<student,String>("email"));
        table_view.setItems(stdlist);
    }
        public void delete_button_action(ActionEvent actionEvent) throws SQLException {
        ObservableList<student>selecteditems=FXCollections.observableArrayList();
        selecteditems=table_view.getSelectionModel().getSelectedItems();
            database db=new database();
            Connection conn=db.getConnection();
            for(student std:selecteditems){
                String sql="delete from student where ID=?";
                PreparedStatement statement=conn.prepareStatement(sql);
                statement.setString(1,std.getId());
                statement.executeUpdate();
            }
        stdlist.removeAll(selecteditems);
        return  ;
    }

}
