package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class DashboardFormController {

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnPlace;

    @FXML
    private AnchorPane rootNode;


    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        navigateToTheCustomerForm();
    }

    private void navigateToTheCustomerForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/customerForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Customer Form");
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        navigateToTheItemForm();
    }

    private void navigateToTheItemForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/itemForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Item Form");
    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) throws IOException {
        navigateToThePlaceOrderForm();
    }

    private void navigateToThePlaceOrderForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/placeorderForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Place order Form");
    }

}
