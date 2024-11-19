package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.bo.custom.StudentBO;

import lk.ijse.bo.custom.EnrollmentBO;
import lk.ijse.dto.EnrollmentDetailDto;
import lk.ijse.dto.EnrollmentDto;
import lk.ijse.dto.ProgramDto;
import lk.ijse.dto.StudentDto;

import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import lk.ijse.view.tdm.EnrollmentDetailTm;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterFormController {

    public AnchorPane rootNode;
    public TextField txtStuName;
    public TextField txtProgram;
    public TextField txtPayment;
    public TextField txtDuration;
    public TextField txtYrs;
    public ComboBox<String> cmbStudentId;
    public ComboBox<String> cmbProgramId;
    public TableView tblRegisterDetails;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colPayment;
    public TableColumn colDuration;
    public TableColumn colYears;
    public TextField txtTotal;
    public TextField txtEnrollmentId;
    public TextField txtDate;
    public TextField txtYears;
    public TableColumn colEnrollmentID;

    private ObservableList<EnrollmentDetailTm> obList = FXCollections.observableArrayList();
    EnrollmentBO enrollmentBO = (EnrollmentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Enrollment);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAM);


    public void initialize() {
        loadProgramIds();
        loadStudentIds();
        getCurrentOrderId();
        setDate();
        setCellValueFactory();
        cmbStudentId.setOnAction(this::cmbIdSearchOnAction);
    }

    private void setCellValueFactory() {
        //colEnrollmentID.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colEnrollmentID.setCellValueFactory(new PropertyValueFactory<>("enrollmentId"));
        colProgramID.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colYears.setCellValueFactory(new PropertyValueFactory<>("years"));

    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        txtDate.setText(String.valueOf(now));
    }

    // Load student IDs into cmbStudentId ComboBox
    private void loadStudentIds() {
        List<StudentDto> studentDtos = enrollmentBO.getAllStudents();

        for (StudentDto studentDto : studentDtos) {
            cmbStudentId.getItems().add(studentDto.getId());
        }
    }

    // Load program IDs into cmbProgramId ComboBox
    private void loadProgramIds() {
        List<ProgramDto> programDtos = programBO.getAllPrograms();

        for (ProgramDto programDto : programDtos) {
            cmbProgramId.getItems().add(programDto.getProgramCode());
        }
    }

    private void getCurrentOrderId() {
        try {
            Object currentId = enrollmentBO.currentId();
            String nextId = generateNextOrderID(currentId);
            txtEnrollmentId.setText(nextId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextOrderID(Object currentId) {

        currentId = (String) enrollmentBO.currentId();
        System.out.println(currentId);
        if (currentId != null) {
            int curId = Integer.parseInt(((String) currentId).replace("OID-", "")) + 1;
            String nextId = String.format("OID-%03d", curId);
            return nextId;
        } else {
            return "OID-001";
        }
    }

    // This method is triggered when a student ID is selected from cmbStudentId ComboBox
    public void cmbIdSearchOnAction(ActionEvent actionEvent) {
        String studentId = cmbStudentId.getSelectionModel().getSelectedItem();
        System.out.println("Selected student ID: " + studentId); // Debug

        if (studentId != null) {
            StudentDto studentDto = studentBO.searchStudent(studentId);
            if (studentDto != null) {
                txtStuName.setText(studentDto.getName());
            } else {
                showAlert("Error", "Student not found for ID: " + studentId, Alert.AlertType.ERROR);
            }
        }
    }

    // Add selected student to the program
    public void btnAddToProgramOnAction(ActionEvent actionEvent) {
        String enrollmentId = txtEnrollmentId.getText();
        String studentID = cmbStudentId.getValue();
        String studentName = txtStuName.getText();
        String programId = cmbProgramId.getValue();
        String programName = txtProgram.getText();
        LocalDate date = LocalDate.parse(txtDate.getText());
        String payment = txtPayment.getText();
        String duration = txtDuration.getText();
        Integer years = Integer.valueOf(txtYears.getText());

        EnrollmentDetailTm tm = new EnrollmentDetailTm(enrollmentId, studentID, studentName, programId, programName, date, payment, duration, years);
        obList.add(tm);

        tblRegisterDetails.setItems(obList);

    }

    // Utility method to show alert messages
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Reset the form after enrollment
    private void resetForm() {
        txtStuName.clear();
        txtProgram.clear();
        txtPayment.clear();
        txtDuration.clear();
        txtYrs.clear();
        txtTotal.clear();
        txtEnrollmentId.clear();
        txtDate.clear();
        cmbStudentId.getSelectionModel().clearSelection();
        cmbProgramId.getSelectionModel().clearSelection();
    }



    // Search for a program when selected from cmbProgramId ComboBox
    public void cmbProgramIdSearchOnAction(ActionEvent actionEvent) throws SQLException {
        String programId = cmbProgramId.getSelectionModel().getSelectedItem();
        Program programDto = programBO.search(programId);
        txtProgram.setText(programDto.getProgramName());
        txtPayment.setText(programDto.getProgramDuration());
        txtDuration.setText(programDto.getProgramFee());


    }

    // Register the student and perform necessary actions like calculation and saving
    public void btnRegisterOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        // Retrieve the enrollment ID from the UI
        String enrollmentId = txtEnrollmentId.getText();

        // Get the current date for enrollment date
        LocalDate enrollmentDate = LocalDate.now();

        // Fetch student details using the studentBO (assuming studentBO.searchStudent returns a StudentDto)
        StudentDto studentDto = studentBO.searchStudent(cmbStudentId.getValue());

        // Create a new Student object and set its details from the studentDto
        Student student = new Student();
        student.setId(cmbStudentId.getValue());  // Assuming cmbStudentId.getValue() returns the student ID
        student.setName(studentDto.getName());
        student.setGender(studentDto.getGender());
        student.setBirthDay(studentDto.getBirthDay());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAddress(studentDto.getAddress());

        // Fetch the program details (program object)
        Program program = programBO.search(cmbProgramId.getValue()); // Assuming cmbProgramCode returns the selected program

        // Retrieve other details like payment, duration, and years
        String payment = txtPayment.getText();  // Example text field for payment
        String duration = txtDuration.getText();  // Example text field for duration
        int years = Integer.parseInt(txtYears.getText());  // Example text field for years

        // Create an EnrollmentDto object with all the gathered data
        EnrollmentDto enrollmentDto = new EnrollmentDto(
                enrollmentId,          // enrollmentId (String)
                student,               // student (Student)
                program,               // program (Program)
                enrollmentDate,        // enrollmentDate (LocalDate)
                payment,               // payment (String)
                duration,              // duration (String)
                years                  // years (int)
        );


        List<EnrollmentDetailDto> enrollmentDetailDtos = new ArrayList<>();
        for (int i = 0; i < tblRegisterDetails.getItems().size(); i++) {
            EnrollmentDetailTm tm = obList.get(i); // Fetch data from the table row (Tm object)

            EnrollmentDetailDto dto = new EnrollmentDetailDto(
                    tm.getEnrollmentId(),          // Enrollment ID
                    tm.getProgramId(),             // Course Code (mapped from Program ID)
                    tm.getStudentId(),             // Student ID
                    tm.getEnrollmentDate()         // Enrollment Date
            );

            enrollmentDetailDtos.add(dto); // Add to the list
        }

        enrollmentBO.registerEnrollment(enrollmentDto,enrollmentDetailDtos);
    }
}

