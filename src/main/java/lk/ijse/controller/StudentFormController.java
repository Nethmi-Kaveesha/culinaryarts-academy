package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.dto.StudentDto;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;
import lk.ijse.view.tdm.StudentTm;

import java.time.LocalDate;
import java.util.List;

public class StudentFormController {

    public AnchorPane rootNode;
    @FXML
    private TableColumn<?,?> stuAddress_col;

    @FXML
    private Button stuClearBtn;

    @FXML
    private Button stuDeleteBtn;

    @FXML
    private TableColumn<?,?> stuEmail_col;

    @FXML
    private TableColumn<?,?> stuGender_col;

    @FXML
    private TableColumn<?,?> stuId_col;

    @FXML
    private TableColumn<?,?> stuName_col;

    @FXML
    private TableColumn<?,?> stuPhone_col;

    @FXML
    private Button stu_AddBtn;

    @FXML
    private TextField stu_Address;

    @FXML
    private Button stu_UpdateBtn;

    @FXML
    private DatePicker stu_birthday;

    @FXML
    private TextField stu_email;

    @FXML
    private ComboBox<String> stu_gender; // Specify type

    @FXML
    private TextField stu_id;

    @FXML
    private TextField stu_name;

    @FXML
    private TableColumn<?,?> stuBirthday_col;

    @FXML
    private TextField stu_phone;

    @FXML
    private TableView<StudentTm> stu_table;



    StudentBO studentBO = new StudentBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllStudents();

        stu_gender.getItems().addAll("Male", "Female");

        // Add listener for row selection
        stu_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setFieldsWithSelectedRowData(newValue);
            }
        });
    }

    public String generateNewId() {
        List<StudentDto> students = loadAllStudents(); // Assuming this method retrieves all students
        int maxId = 0;

        for (StudentDto student : students) {
            // Convert the existing IDs to integers
            int currentId = Integer.parseInt(student.getId());
            if (currentId > maxId) {
                maxId = currentId; // Find the maximum ID
            }
        }

        // Generate new ID by incrementing the highest ID found
        return String.valueOf(maxId + 1); // Return the new ID as a string
    }


    private void setCellValueFactory() {
        stuId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        stuName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        stuGender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        stuBirthday_col.setCellValueFactory(new PropertyValueFactory<>("birthDay")); // Match case
        stuEmail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        stuPhone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        stuAddress_col.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private List<StudentDto> loadAllStudents() {
        ObservableList<StudentTm> obList = FXCollections.observableArrayList();

        try {
            List<StudentDto> studentList = studentBO.getAllStudents();

            for (StudentDto studentDto : studentList) {
                // Ensure that the birth date is formatted correctly for display
                String formattedBirthDay = studentDto.getBirthDay().toString(); // Adjust if custom format needed

                // Create StudentTm object with the formatted data
                StudentTm studentTm = new StudentTm(
                        studentDto.getId(),
                        studentDto.getName(),
                        studentDto.getGender(),
                        formattedBirthDay, // Ensure correct format for DatePicker or String display
                        studentDto.getEmail(),
                        studentDto.getPhone(),
                        studentDto.getAddress()
                );

                // Add each student to the ObservableList
                obList.add(studentTm);
            }

            // Set the ObservableList in the TableView
            stu_table.setItems(obList);

        } catch (Exception e) {
            // Improved error alert with specific details
            new Alert(Alert.AlertType.ERROR, "Error loading students: " + e.getMessage(), ButtonType.OK).show();
        }
        return null;
    }


    public void btnSaveOnAction(ActionEvent actionEvent) {
        // Validate text fields
        boolean isValid = true;

        isValid &= Regex.setTextColor(TextFields.StudentID, stu_id);
        isValid &= Regex.setTextColor(TextFields.FullName, stu_name);
        isValid &= Regex.setTextColor(TextFields.Email, stu_email);
        isValid &= Regex.setTextColor(TextFields.Phone, stu_phone);
        isValid &= Regex.setTextColor(TextFields.Address, stu_Address);

        // Proceed only if all fields are valid
        if (isValid) {
            boolean isSaved = studentBO.save(new StudentDto(
                    stu_id.getText(),
                    stu_name.getText(),
                    stu_gender.getValue(),
                    stu_birthday.getValue(),
                    stu_email.getText(),
                    stu_phone.getText(),
                    stu_Address.getText()
            ));

            if (isSaved) {
                loadAllStudents();
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student UnSaved").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please correct the highlighted fields.").show();
        }
    }



    public void btnUpdateOnAction(ActionEvent actionEvent) {
        boolean isUpdated = studentBO.update(new StudentDto(stu_id.getText(), stu_name.getText(), stu_gender.getValue(), stu_birthday.getValue(), stu_email.getText(), stu_phone.getText(), stu_Address.getText()));
        if(isUpdated){
            loadAllStudents();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Student Updated").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student UnUpdated").show();
        }
    }

    private void setFieldsWithSelectedRowData(StudentTm selectedStudent) {
        stu_id.setText(selectedStudent.getId());
        stu_name.setText(selectedStudent.getName());

        // Set the gender in ComboBox
        stu_gender.setValue(selectedStudent.getGender()); // Ensure that the gender value matches one of the ComboBox items

        stu_birthday.setValue(LocalDate.parse(selectedStudent.getBirthDay())); // Ensure correct format
        stu_email.setText(selectedStudent.getEmail());
        stu_phone.setText(selectedStudent.getPhone());
        stu_Address.setText(selectedStudent.getAddress());
    }


    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted = studentBO.delete(new StudentDto(stu_id.getText(), stu_name.getText(), stu_gender.getValue(), stu_birthday.getValue(), stu_email.getText(), stu_phone.getText(), stu_Address.getText()));
        if(isDeleted) {
            loadAllStudents();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student UnDeleted").show();
        }

    }

    private void clearFields() {
        stu_id.setText("");
        stu_name.setText("");
        stu_gender.getSelectionModel().clearSelection(); // Clear selected item from ComboBox
        stu_birthday.setValue(null);
        stu_email.setText("");
        stu_phone.setText("");
        stu_Address.setText(""); // Assuming you want to clear this field too
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        stu_Address.requestFocus();
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        stu_phone.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        stu_email.requestFocus();
    }

    public void txtBirthdayOnAction(ActionEvent actionEvent) {
        stu_birthday.requestFocus();
    }

    public void txtGenderOnAction(ActionEvent actionEvent) {
        stu_gender.requestFocus();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        stu_name.requestFocus();
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
        stu_id.requestFocus();
    }
}
