package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.bo.custom.impl.ProgramBOImpl;
import lk.ijse.dto.ProgramDto;
import lk.ijse.view.tdm.ProgramTm;

import java.util.List;

public class ProgramController {

    public AnchorPane rootNode;
    @FXML
    private TableColumn<ProgramTm, String> programId_col;

    @FXML
    private TableColumn<ProgramTm, String> programName_col;

    @FXML
    private TableColumn<ProgramTm, String> programDuration_col;

    @FXML
    private TableColumn<ProgramTm, String> programFee_col;

    @FXML
    private Button programClearBtn;

    @FXML
    private Button programDeleteBtn;

    @FXML
    private Button program_AddBtn;

    @FXML
    private Button program_UpdateBtn;

    @FXML
    private TextField program_id;

    @FXML
    private TextField program_name;

    @FXML
    private TextField program_duration;

    @FXML
    private TextField program_fee;

    @FXML
    private TableView<ProgramTm> program_table;

    

    ProgramBO programBO = new ProgramBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllPrograms();
    }

    private void setCellValueFactory() {
        programId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        programName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        programDuration_col.setCellValueFactory(new PropertyValueFactory<>("duration"));
        programFee_col.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void loadAllPrograms() {
        ObservableList<ProgramTm> obList = FXCollections.observableArrayList();

        try {
            List<ProgramDto> programList = programBO.getAllPrograms();

            for (ProgramDto programDto : programList) {
                // Create ProgramTm object with the formatted data
                ProgramTm programTm = new ProgramTm(
                        programDto.getProgramCode(),
                        programDto.getProgramName(),
                        programDto.getProgramDuration(),
                        programDto.getProgramFee()
                );

                // Add each program to the ObservableList
                obList.add(programTm);
            }

            // Set the ObservableList in the TableView
            program_table.setItems(obList);

        } catch (Exception e) {
            // Improved error alert with specific details
            new Alert(Alert.AlertType.ERROR, "Error loading programs: " + e.getMessage(), ButtonType.OK).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isSaved = programBO.save(new ProgramDto(program_id.getText(), program_name.getText(), program_duration.getText(), program_fee.getText()));
        if (isSaved) {
            loadAllPrograms();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Saved").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Program UnSaved").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        boolean isUpdated = programBO.update(new ProgramDto(program_id.getText(), program_name.getText(), program_duration.getText(),program_fee.getText()));
        if (isUpdated) {
            loadAllPrograms();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Updated").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Program UnUpdated").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted = programBO.delete(new ProgramDto(program_id.getText(), program_name.getText(), program_duration.getText(), program_fee.getText()));
        if (isDeleted) {
            loadAllPrograms();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Deleted").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Program UnDeleted").show();
        }
    }

    private void clearFields() {
        program_id.setText("");
        program_name.setText("");
        program_duration.setText("");
        program_fee.setText("");
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
        program_id.requestFocus();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        program_name.requestFocus();
    }

    public void txtDurationOnAction(ActionEvent actionEvent) {
        program_duration.requestFocus();
    }

    public void txtFeeOnAction(ActionEvent actionEvent) {
        program_fee.requestFocus();
    }
}
