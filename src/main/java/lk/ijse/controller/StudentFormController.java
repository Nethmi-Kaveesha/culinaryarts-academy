import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudenFormController {

    @FXML
    private TableColumn<?, ?> stuAddress_col;

    @FXML
    private Button stuClearBtn;

    @FXML
    private Button stuDeleteBtn;

    @FXML
    private TableColumn<?, ?> stuEmail_col;

    @FXML
    private TableColumn<?, ?> stuGender_col;

    @FXML
    private TableColumn<?, ?> stuId_col;

    @FXML
    private TableColumn<?, ?> stuName_col;

    @FXML
    private TableColumn<?, ?> stuPhone_col;

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
    private ComboBox<?> stu_gender;

    @FXML
    private TextField stu_id;

    @FXML
    private TextField stu_name;

    @FXML
    private TextField stu_phone;

    @FXML
    private TableView<?> stu_table;

}
