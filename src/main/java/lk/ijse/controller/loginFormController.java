package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class loginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnTogglePassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPasswordVisible;

    @FXML
    private TextField txtUserName;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username = txtUserName.getText();
        String password = getPassword();

        try {
            // Find user by username
            UserDto user = userBO.findUserByUsername(username);
            if (user != null && verifyPassword(password, user.getPassword())) {
                // If login is successful, navigate to the DashboardForm
                loadDashboardForm();
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while logging in.");
        }
    }

    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (hashedPassword == null || (!hashedPassword.startsWith("$2a$") && !hashedPassword.startsWith("$2b$") && !hashedPassword.startsWith("$2y$"))) {
            throw new IllegalArgumentException("Invalid hashed password format");
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    private void loadDashboardForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboardForm.fxml"));
            AnchorPane dashboardRoot = fxmlLoader.load();

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
            stage.setTitle("Dashboard");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the dashboard.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void togglePasswordVisibility(ActionEvent event) {
        if (txtPassword.isVisible()) {
            txtPassword.setVisible(false);
            txtPasswordVisible.setText(txtPassword.getText());
            txtPasswordVisible.setVisible(true);
            btnTogglePassword.setText("Hide");
        } else {
            txtPasswordVisible.setVisible(false);
            txtPassword.setText(txtPasswordVisible.getText());
            txtPassword.setVisible(true);
            btnTogglePassword.setText("Show");
        }
    }

    private String getPassword() {
        return txtPassword.isVisible() ? txtPassword.getText() : txtPasswordVisible.getText();
    }
}
