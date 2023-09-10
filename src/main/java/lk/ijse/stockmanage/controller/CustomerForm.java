package lk.ijse.stockmanage.controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.stockmanage.Dto.Customerdto;
import lk.ijse.stockmanage.Dto.Itemdto;
import lk.ijse.stockmanage.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerForm {
    public TextField txtSalary;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtId;


    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        try {
            Connection con = DbConnection.getInstance().getConnection();

            String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, address);
            pstm.setDouble(4, salary);

            boolean isSaved = pstm.executeUpdate() > 0;
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void txtIdOnAction(ActionEvent actionEvent) {
       String id= txtId.getText();
        try {
            Connection connection=DbConnection.getInstance().getConnection();
            String sql="SELECT * from customer where id=?";
            PreparedStatement pstm= connection.prepareStatement(sql);
            pstm.setString(1,id);
            ResultSet resultSet=pstm.executeQuery();
            if(resultSet.next()) {
                String cusId = resultSet.getString(1);
                String cusName = resultSet.getString(2);
                String cusAddress = resultSet.getString(3);
                double cusSalary = resultSet.getDouble(4);

                var customerDto = new Customerdto(cusId,cusName,cusAddress,cusSalary);
                fillFields(customerDto);

            } else {
                new Alert(Alert.AlertType.WARNING, "oops! customer not found!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillFields(Customerdto customerdto) {
        txtId.setText(customerdto.getId());
        txtName.setText(customerdto.getName());
        txtAddress.setText(customerdto.getAddress());
        txtSalary.setText(String.valueOf(customerdto.getSalaray()));
    }
    public void clearbtnOnAction(ActionEvent actionEvent) {
        clearFields();
    }
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
    }

    public void updatebtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        try {
            Connection con = DbConnection.getInstance().getConnection();

            String sql = "UPDATE customer set name = ?, address = ?, salary = ? WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, address);
            pstm.setDouble(3, salary);
            pstm.setString(4, id);

            boolean isUpdated = pstm.executeUpdate() > 0;

            if(isUpdated) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void deletebtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            Connection con = DbConnection.getInstance().getConnection();
            String sql = "DELETE FROM customer WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            boolean isDeleted = pstm.executeUpdate() > 0;

            if(isDeleted) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    }

