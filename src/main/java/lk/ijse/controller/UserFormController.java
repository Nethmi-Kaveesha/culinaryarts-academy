package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.bo.custom.impl.UserBOImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.view.tdm.UserTm;

import java.util.List;

public class UserFormController {

    public AnchorPane rootNode;
    public TextField user_password;
    public TableColumn userPassword_col;

    @FXML
    private TableColumn<UserTm, String> userId_col;

    @FXML
    private TableColumn<UserTm, String> userName_col;

    @FXML
    private TableColumn<UserTm, String> userEmail_col;

    @FXML
    private TableColumn<UserTm, String> userRole_col;

    @FXML
    private Button userClearBtn;

    @FXML
    private Button userDeleteBtn;

    @FXML
    private Button userAddBtn;

    @FXML
    private Button userUpdateBtn;

    @FXML
    private TextField user_id;

    @FXML
    private TextField user_name;

    @FXML
    private TextField user_email;

    @FXML
    private ComboBox<String> user_role;

    @FXML
    private TableView<UserTm> user_table;

   

    UserBO userBO = new UserBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllUsers(); // Call this method to load users initially
    }

    private void setCellValueFactory() {
        userId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        userName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        userEmail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        userRole_col.setCellValueFactory(new PropertyValueFactory<>("role"));
    }

    private void loadAllUsers() {
        ObservableList<UserTm> obList = FXCollections.observableArrayList();

        try {
            List<UserDto> userList = userBO.getAllUsers();

            for (UserDto userDto : userList) {
                UserTm userTm = new UserTm(
                        userDto.getUserId(),
                        userDto.getUsername(),
                        userDto.getPassword(),
                        userDto.getRole()
                );

                obList.add(userTm);
            }

            user_table.setItems(obList);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading users: " + e.getMessage(), ButtonType.OK).show();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        boolean isSaved = userBO.save(new UserDto(user_id.getText(), user_name.getText(), user_email.getText(), user_role.getValue()));
        if(isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "User Saved").show();
            loadAllUsers(); // Refresh the table
        } else {
            new Alert(Alert.AlertType.ERROR, "User Not Saved").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        boolean isUpdated = userBO.update(new UserDto(user_id.getText(), user_name.getText(), user_email.getText(), user_role.getValue()));
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION, "User Updated").show();
            loadAllUsers(); // Refresh the table
        } else {
            new Alert(Alert.AlertType.ERROR, "User Not Updated").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted = userBO.delete(new UserDto(user_id.getText(), user_name.getText(), user_email.getText(), user_role.getValue()));
        if(isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted").show();
            loadAllUsers(); // Refresh the table
        } else {
            new Alert(Alert.AlertType.ERROR, "User Not Deleted").show();
        }
    }

    private void clearFields() {
        user_id.setText("");
        user_name.setText("");
        user_email.setText("");
        user_role.getSelectionModel().clearSelection(); // Clear selected item from ComboBox
    }

    // Event handlers for TextField actions
    public void txtIdOnAction(ActionEvent actionEvent) {
        user_name.requestFocus();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        user_email.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        user_role.requestFocus();
    }



    public void txtRoleOnAction(ActionEvent actionEvent) {
        user_role.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
    }
}
