package lk.ijse.stockmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.stockmanage.db.Db;

import java.io.IOException;

public class LoginForm {

    public TextField user;
    public TextField password;
    public AnchorPane root;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
String User_Name= user.getText();
String Password=password.getText();

if(User_Name.equals(Db.User_Name)&& Password.equals(Db.Password)){
    //navigate to dashboard
    navigate();
}else{
    new Alert(Alert.AlertType.ERROR,"Creditials are Wrong").show();

}

    }
    public void navigate() throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/View/dashboard_form.fxml"));
        Scene scene=new Scene(root);
        Stage stage=(Stage)this.root.getScene().getWindow();
stage.setScene(scene);
stage.setTitle("Dashboard");
stage.centerOnScreen();
    }
}
