package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserDashController {

    public Button btnRejister;
    public Button btnAboutUs;
    public Button btnContact;
    public Button btnHome1;
    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnPlace;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane contentArea; // AnchorPane in which to load the forms

    @FXML
    private Text userIdLabel; // Label to display the user ID

    private String userId;
    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        loadStudentForm();
    }

    private void loadStudentForm() throws IOException {
        AnchorPane studentForm = FXMLLoader.load(getClass().getResource("/view/Student.fxml"));

        // Clear existing content and load new form
        contentArea.getChildren().clear();
        contentArea.getChildren().add(studentForm);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        loadProgramForm();
    }

    private void loadProgramForm() throws IOException {
        AnchorPane programForm = FXMLLoader.load(getClass().getResource("/view/show-programs.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(programForm);
    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) throws IOException {
        loadPlaceOrderForm();
    }

    private void loadPlaceOrderForm() throws IOException {
        AnchorPane placeOrderForm = FXMLLoader.load(getClass().getResource("/view/UserForm.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(placeOrderForm);
    }

    public void setUserId(String userId) {
        this.userId = userId;
        userIdLabel.setText("Welcome, " + userId + "!"); // Display welcome message
    }

    private void loadRejisterForm() throws IOException {
        AnchorPane placeOrderForm = FXMLLoader.load(getClass().getResource("/view/order_form.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(placeOrderForm);
    }

    private void loadAboutUsForm() throws IOException{
        AnchorPane placeOrderForm = FXMLLoader.load(getClass().getResource("/view/AboutUsForm.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(placeOrderForm);
    }

    private void loadHomeForm() throws IOException{
        AnchorPane placeOrderForm = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(placeOrderForm);
    }

    private void loadContactUsForm() throws IOException{
        AnchorPane placeOrderForm = FXMLLoader.load(getClass().getResource("/view/ContactUsForm.fxml"));

        contentArea.getChildren().clear();
        contentArea.getChildren().add(placeOrderForm);
    }


    public void btnRejisterOnAction(ActionEvent actionEvent) throws IOException {
        loadRejisterForm();
    }

    public void btnAboutOnAction(ActionEvent event) throws IOException {
        loadAboutUsForm();
    }

    public void btnContactOnAction(ActionEvent event) throws IOException {
        loadContactUsForm();
    }

    public void btnHomeOnAction(ActionEvent event) throws IOException {
        loadHomeForm();
    }
}
