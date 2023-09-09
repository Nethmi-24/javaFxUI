package lk.ijse.stockmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemformController {
    public AnchorPane root;

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode= FXMLLoader.load(this.getClass().getResource("/View/dashboard_form.fxml"));
        Stage stage=(Stage)this.root.getScene().getWindow();
        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
    }
}
