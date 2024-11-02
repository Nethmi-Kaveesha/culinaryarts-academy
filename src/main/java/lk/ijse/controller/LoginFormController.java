package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginFormController {

    @FXML
    private BorderPane login_form; // Reference to the login form
    @FXML
    private BorderPane signup_form; // Reference to the signup form

    @FXML
    private TextField si_username; // Username field for login
    @FXML
    private TextField si_password; // Password field for login

    @FXML
    private TextField su_username; // Username field for signup
    @FXML
    private TextField su_password; // Password field for signup

    @FXML
    private Button si_loginBtn; // Login button
    @FXML
    private Button su_signupBtn; // Signup button

    @FXML
    private Button si_createAccountBtn; // Button to switch to signup form
    @FXML
    private Button su_loginAccountBtn; // Button to switch to login form

    @FXML
    private Label loginErrorLabel; // Label for login errors
    @FXML
    private Label signupErrorLabel; // Label for signup errors

    // Simulated user database
    private static final Map<String, String> userDatabase = new HashMap<>();

    @FXML
    private void initialize() {
        // Prepopulate with some users for testing
        userDatabase.put("admin", "password"); // Example user
    }

    @FXML
    private void handleLogin() {
        String username = si_username.getText();
        String password = si_password.getText();

        // Perform login validation
        if (validateLogin(username, password)) {
            String userId = username; // Simulated user ID, can be changed to an actual ID retrieval from DB

            try {
                Stage stage = (Stage) si_loginBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboardForm.fxml"));
                Scene dashboardScene = new Scene(loader.load());

                // Pass user ID to the dashboard controller
                DashboardFormController dashboardController = loader.getController();
                dashboardController.setUserId(userId);

                stage.setScene(dashboardScene);
                stage.setTitle("Dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                loginErrorLabel.setText("Error loading dashboard.");
            }
        } else {
            loginErrorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    private void handleSignUp() {
        String username = su_username.getText();
        String password = su_password.getText();

        if (validateSignup(username, password)) {
            userDatabase.put(username, password);
            su_username.clear();
            su_password.clear();
            switchToLoginForm(); // Switch back to the login form
        } else {
            signupErrorLabel.setText("Username already exists or invalid input.");
        }
    }

    @FXML
    private void switchToSignupForm() {
        login_form.setVisible(false);
        signup_form.setVisible(true);
    }

    @FXML
    private void switchToLoginForm() {
        signup_form.setVisible(false);
        login_form.setVisible(true);
    }

    private boolean validateLogin(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    private boolean validateSignup(String username, String password) {
        return username != null && !username.isEmpty() && password != null && password.length() >= 6 && !userDatabase.containsKey(username);
    }

    public void handleLoginAccount(ActionEvent actionEvent) {
        // Additional logic if needed when switching accounts
    }

    public void handleCreateAccount(ActionEvent actionEvent) {
        // Additional logic if needed when creating an account
    }
}
