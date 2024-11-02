package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.internal.icu.text.NormalizerBase;

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
    private String userId;


    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        navigateToTheCustomerForm();
    }

    private void navigateToTheCustomerForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/Student.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Student Form");
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        navigateToTheItemForm();
    }

    private void navigateToTheItemForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/ProgramForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Program Form");
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

    public void setUserId(String userId) {
        NormalizerBase userIdLabel = null;
        userIdLabel.setText("Welcome, " + userId + "!"); // Display welcome message
    }


}
