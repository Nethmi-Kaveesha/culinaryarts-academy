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
    public ComboBox program_name;
    @FXML
    private TableColumn<?, ?> programId_col;

    @FXML
    private TableColumn<?, ?> programName_col;

    @FXML
    private TableColumn<?, ?> programDuration_col;

    @FXML
    private TableColumn<?, ?> programFee_col;

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
    private TextField program_duration;

    @FXML
    private TextField program_fee;

    @FXML
    private TableView<ProgramTm> program_table;

    

    ProgramBO programBO = new ProgramBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllPrograms();

        program_name.getItems().addAll("Basic Culinary Skills", "Advanced Culinary Arts","Pastry and Baking Fundamentals","Professional Chef Training","International Cuisine","Vegetarian and Vegan Cooking","Food Safety and Hygiene","Culinary Management");

        program_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populateFields(newValue);
            }
        });
    }

    private void setCellValueFactory() {
        programId_col.setCellValueFactory(new PropertyValueFactory<>("programCode"));
        programName_col.setCellValueFactory(new PropertyValueFactory<>("programName"));
        programDuration_col.setCellValueFactory(new PropertyValueFactory<>("programFee"));
        programFee_col.setCellValueFactory(new PropertyValueFactory<>("programDuration"));
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

    private void populateFields(ProgramTm programTm) {
        program_id.setText(programTm.getProgramCode());
        program_name.setValue(programTm.getProgramName());
        program_duration.setText(programTm.getProgramDuration());
        program_fee.setText(programTm.getProgramFee());
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        // Ensure a program name is selected
        String selectedProgramName = (String) program_name.getValue();
        if (selectedProgramName == null || selectedProgramName.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please select a program name").show();
            return;
        }

        // Save the program details
        boolean isSaved = programBO.save(new ProgramDto(program_id.getText(), selectedProgramName, program_duration.getText(), program_fee.getText()));
        if (isSaved) {
            loadAllPrograms();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Saved").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Program not saved").show();
        }
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        // Validate fields before attempting update
        if (program_id.getText().isEmpty() || program_name.getValue() == null ||
                program_duration.getText().isEmpty() || program_fee.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields before updating.").show();
            return;
        }

        // Attempt to update program
        boolean isUpdated = programBO.update(new ProgramDto(
                program_id.getText(),
                (String) program_name.getValue(),
                program_duration.getText(),
                program_fee.getText()
        ));

        // Check the result of the update operation
        if (isUpdated) {
            loadAllPrograms();
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Updated").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Update failed. Please check your inputs and try again.").show();
        }
    }


    public void btnClearOnAction(ActionEvent actionEvent) {

        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted = programBO.delete(new ProgramDto(program_id.getText(), (String) program_name.getValue(), program_duration.getText(), program_fee.getText()));
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
        program_name.getSelectionModel().clearSelection();
        program_duration.setText("");
        program_fee.setText("");
    }

    public void txtIdOnAction(ActionEvent actionEvent) {
        program_id.requestFocus();
    }



    public void txtDurationOnAction(ActionEvent actionEvent) {
        program_duration.requestFocus();
    }

    public void txtFeeOnAction(ActionEvent actionEvent) {
        program_fee.requestFocus();
    }
}
