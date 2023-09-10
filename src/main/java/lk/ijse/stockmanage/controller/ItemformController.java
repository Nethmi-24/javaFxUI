package lk.ijse.stockmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.stockmanage.Dto.Itemdto;
import lk.ijse.stockmanage.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemformController {
    public AnchorPane root;
    public TextField TxtCode;
    public TextField TxtDesc;
    public TextField TextUprice;
    public TextField Textqty;


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode= FXMLLoader.load(this.getClass().getResource("/View/dashboard_form.fxml"));
        Stage stage=(Stage)this.root.getScene().getWindow();
        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
    }

    public void saveBtnOnAction(ActionEvent actionEvent) {
        String code = TxtCode.getText();
        String description = TxtDesc.getText();
        double uPrice = Double.parseDouble(TextUprice.getText());
        int qty = Integer.parseInt(Textqty.getText());
        try {
            Connection con = DbConnection.getInstance().getConnection();

            String sql = "INSERT INTO item VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);
            pstm.setString(2, description);
            pstm.setDouble(3, uPrice);
            pstm.setInt(4, qty);

            boolean isSaved = pstm.executeUpdate() > 0;
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void TxtCodeOnAction(ActionEvent actionEvent) {
        String CodeId= TxtCode.getText();
        try {
            Connection connection=DbConnection.getInstance().getConnection();
            String sql="SELECT * from item where code=?";
            PreparedStatement pstm= connection.prepareStatement(sql);
            pstm.setString(1,CodeId);
            ResultSet resultSet=pstm.executeQuery();
            if(resultSet.next()) {
                String code = resultSet.getString(1);
                String description = resultSet.getString(2);
                double uPrice = resultSet.getDouble(3);
                int qty = resultSet.getInt(4);
                var itemDto = new Itemdto(code, description, uPrice, qty);

                fillFields(itemDto);
            } else {
                new Alert(Alert.AlertType.WARNING, "oops! item is not found!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillFields(Itemdto itemDto) {
        TxtCode.setText(itemDto.getCode());
        TxtDesc.setText(itemDto.getDescription());
        TextUprice.setText(String.valueOf(itemDto.getuPrice()));
        Textqty.setText(String.valueOf(itemDto.getQty()));
    }
    public void clearBtnOnAction(ActionEvent actionEvent) {
       clearFields();

    }

    private void clearFields() {
        TxtCode.setText("");
        TxtDesc.setText("");
        TextUprice.setText("");
        Textqty.setText("");
    }


    public void updateBtnOnAction(ActionEvent actionEvent) {

    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
        String CodeId = TxtCode.getText();

        try {
            Connection con = DbConnection.getInstance().getConnection();
            String sql = "DELETE FROM item WHERE code = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, CodeId);

            boolean isDeleted = pstm.executeUpdate() > 0;

            if(isDeleted) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Item deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
