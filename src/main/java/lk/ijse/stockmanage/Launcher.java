package lk.ijse.stockmanage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
//load fxml file
        Parent root= FXMLLoader.load(this.getClass().getResource("/View/itemForm.fxml"));

        //create new scene
        Scene scene=new Scene(root);

        stage.setTitle("Customer Form");
        stage.centerOnScreen();  //load to center of the screen

        //set scene to stage
        stage.setScene(scene);

        //show the stage
        stage.show();
    }
}
