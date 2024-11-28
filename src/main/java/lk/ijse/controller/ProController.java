package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.entity.Program;

public class ProController {

    @FXML
    private TableView<Program> programTable;

    @FXML
    private TableColumn<Program, String> programIdColumn;
    @FXML
    private TableColumn<Program, String> programNameColumn;
    @FXML
    private TableColumn<Program, String> durationColumn;
    @FXML
    private TableColumn<Program, String> feeColumn;

    public void initialize() {
        // Initialize the columns with the correct property names
        setCellValueFactory();

        // Populate the table with sample data
        programTable.getItems().addAll(
                new Program("CA1001", "Professional Cooking", "120,000.00", "1 year"),
                new Program("CA1003", "Baking & Pastry Arts", "60,000.00", "6 months"),
                new Program("CA1004", "International Cuisine", "100,000.00", "1 year"),
                new Program("CA1005", "Culinary Management", "150,000.00", "1 year"),
                new Program("CA1006", "Food Safety and Hygiene", "40,000.00", "3 months")
        );
    }

    // Separate method to set CellValueFactories
    private void setCellValueFactory() {
        programIdColumn.setCellValueFactory(new PropertyValueFactory<>("programCode"));
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("programName"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("programDuration"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<>("programFee"));
    }
}
