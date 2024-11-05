//package lk.ijse.controller;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.AnchorPane;
//import lk.ijse.bo.BOFactory;
//import lk.ijse.bo.custom.ProgramBO;
//import lk.ijse.bo.custom.RejistrationBO;
//import lk.ijse.bo.custom.StudentBO;
//import lk.ijse.dto.EnrollmentDetailsDto;
//import lk.ijse.dto.EnrollmentDto;
//import lk.ijse.dto.ProgramDto;
//import lk.ijse.dto.StudentDto;
//import lk.ijse.entity.Program;
//import lk.ijse.entity.Student;
//import lk.ijse.view.tdm.EnrollmentDetailsTm;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class RejistrationFormController {
//    public AnchorPane rootNode;
//    public TextField txtStuName;
//    public TextField txtProgram;
//    public TextField txtPayment;
//    public TextField txtDuration;
//    public TextField txtYrs;
//    public ComboBox<String> cmbStudentId;
//    public ComboBox<String> cmbProgramId;
//    public TableView<EnrollmentDetailsTm> tblRegisterDetails;
//    public TableColumn<EnrollmentDetailsTm, String> colProgramID;
//    public TableColumn<EnrollmentDetailsTm, String> colProgramName;
//    public TableColumn<EnrollmentDetailsTm, String> colPayment;
//    public TableColumn<EnrollmentDetailsTm, String> colDuration;
//    public TableColumn<EnrollmentDetailsTm, String> colYears;
//    public TextField txtTotal;
//    public TextField txtEnrollmentId;
//    public TextField txtDate;
//
//    private ObservableList<EnrollmentDetailsTm> obList = FXCollections.observableArrayList();
//    RejistrationBO registrationBO = (RejistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REJISTER);
//    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
//    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAM);
//
//    public void initialize() {
//        getProgramCodes();
//        getStudentIds();
//        setCellValueFactory();
//        getCurrentOrderId();
//        setDate();
//    }
//
//    private void setCellValueFactory() {
//        colProgramID.setCellValueFactory(new PropertyValueFactory<>("programId"));
//        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
//        colPayment.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
//        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
//        colYears.setCellValueFactory(new PropertyValueFactory<>("years"));
//    }
//
//    private void setDate() {
//        LocalDate now = LocalDate.now();
//        txtDate.setText(String.valueOf(now));
//    }
//
//    public void cmbIdSearchOnAction(ActionEvent actionEvent) {
//        String stuId = cmbStudentId.getSelectionModel().getSelectedItem();
//        if (stuId != null) {
//            StudentDto studentDto = studentBO.searchStudent(stuId);
//            if (studentDto != null) {
//                txtStuName.setText(studentDto.getName());
//            }
//        }
//    }
//
//    public void cmbItemIdSearchOnAction(ActionEvent actionEvent) {
//        String programId = cmbProgramId.getSelectionModel().getSelectedItem();
//        if (programId != null) {
//            ProgramDto programDto = programBO.search(programId);
//            if (programDto != null) {
//                txtProgram.setText(programDto.getProgramName());
//                txtPayment.setText(String.valueOf(programDto.getProgramFee()));
//                txtDuration.setText(String.valueOf(programDto.getProgramDuration()));
//            }
//        }
//    }
//
//    public void btnAddToProgramOnAction(ActionEvent actionEvent) {
//        String programId = cmbProgramId.getSelectionModel().getSelectedItem();
//        String studentId = cmbStudentId.getSelectionModel().getSelectedItem();
//        String payment = txtPayment.getText();
//        String duration = txtDuration.getText();
//        String years = txtYrs.getText();
//
//        EnrollmentDetailsTm tm = new EnrollmentDetailsTm(programId, studentId, txtStuName.getText(), programId, txtProgram.getText(), LocalDate.now(), payment);
//        obList.add(tm);
//        tblRegisterDetails.setItems(obList);
//    }
//
//    public void btnRegisterOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        String enrollmentID = txtEnrollmentId.getText();
//        Date date = java.sql.Date.valueOf(LocalDate.now());
//
//        StudentDto studentDto = studentBO.searchStudent(cmbStudentId.getValue());
//        if (studentDto != null) {
//            Student student = new Student(
//                    studentDto.getId(),
//                    studentDto.getName(),
//                    studentDto.getGender(),
//                    studentDto.getBirthDay(),
//                    studentDto.getEmail(),
//                    studentDto.getPhone(),
//                    studentDto.getAddress()
//            );
//
//            ProgramDto programDto = programBO.search(cmbProgramId.getValue());
//            if (programDto != null) {
//                Program program = new Program(
//                        programDto.getProgramCode(),
//                        programDto.getProgramName(),
//                        programDto.getProgramFee(),
//                        programDto.getProgramDuration()
//                );
//
//                EnrollmentDto enrollmentDto = new EnrollmentDto(enrollmentID, date, student, program);
//
//                List<EnrollmentDetailsDto> dtoList = new ArrayList<>();
//                for (EnrollmentDetailsTm tm : obList) {
//                    EnrollmentDetailsDto enrollmentDetailsDto = new EnrollmentDetailsDto(
//                            enrollmentID,
//                            tm.getProgramId(),
//                            new BigDecimal(tm.getPaymentStatus())
//                    );
//                    dtoList.add(enrollmentDetailsDto);
//                }
//
//                registrationBO.placeOrder(enrollmentDto, dtoList);
//            }
//        }
//    }
//
//    public void btnHomeOnAction(ActionEvent actionEvent) {
//        // Define your home navigation logic here if needed
//    }
//
//    private void getCurrentOrderId() {
//        try {
//            Object currentId = registrationBO.currentId();
//            String nextId = generateNextOrderID(currentId);
//            txtEnrollmentId.setText(nextId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String generateNextOrderID(Object currentId) {
//        if (currentId != null) {
//            int curId = Integer.parseInt(((String) currentId).replace("OID-", "")) + 1;
//            return String.format("OID-%03d", curId);
//        } else {
//            return "OID-001";
//        }
//    }
//
//    private void getProgramCodes() {
//        List<ProgramDto> programDtos = programBO.getAllPrograms();
//        for (ProgramDto programDto : programDtos) {
//            cmbProgramId.getItems().add(programDto.getProgramCode());
//        }
//    }
//
//    private void getStudentIds() {
//        List<StudentDto> studentDtos = studentBO.getAllStudents();
//        for (StudentDto studentDto : studentDtos) {
//            cmbStudentId.getItems().add(studentDto.getId());
//        }
//    }
//}
