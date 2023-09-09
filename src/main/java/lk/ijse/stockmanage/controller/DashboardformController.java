package lk.ijse.stockmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardformController {
    public AnchorPane rootNode;
    public AnchorPane node;
    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
   //open the customer manager form
        Parent rootNode=FXMLLoader.load(this.getClass().getResource("/View/customerForm.fxml"));
Scene scene=new Scene(rootNode);
Stage stage=new Stage();
stage.setScene(scene);
stage.setTitle("Customer Management");
stage.show();
    }

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode=FXMLLoader.load(this.getClass().getResource("/View/itemForm.fxml"));
        Scene scene=new Scene(rootNode);
        Stage PrimaryStage=(Stage) this.rootNode.getScene().getWindow();
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Item Management");
        //stage.show();
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/View/supplierForm.fxml"));
        //Scene scene=new Scene(root);
        this.node.getChildren().clear();
        this.node.getChildren().add(root);
    }
}
