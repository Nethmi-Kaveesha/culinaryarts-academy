package lk.ijse.util;

import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean isTextFieldValid(TextFields textField, String text) {
        String filled = "";

        switch (textField) {
            case StudentID: // For stu_id
                filled = "^S\\d{3}$"; // Pattern for Student ID (e.g., S123)
                break;
            case FullName:   // For stu_name
                filled = "^[A-Za-z\\s]+$"; // Allows letters and spaces for full names
                break;
            case Email:      // For stu_email
                filled = "^([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,5})$"; // Email pattern
                break;
            case Phone:      // For stu_phone
                filled = "^([+]94|0)([1-9]{2})([0-9]{7})$"; // Sri Lankan phone number format
                break;
            case Address:    // For stu_Address
                filled = "^[A-Za-z0-9\\s,.-]+$"; // Allows letters, numbers, spaces, commas, dots, and hyphens for addresses
                break;
            case ProgramID:  // For program_id
                filled = "^[A-Za-z0-9]{5,10}$"; // Alphanumeric, 5-10 characters
                break;
            case ProgramDuration: // For program_duration
                filled = "^[1-9][0-9]* (days|weeks|months|years)$"; // Format like "12 months"
                break;
            case ProgramFee: // For program_fee
                filled = "^[0-9]+(\\.[0-9]{1,2})?$"; // Numeric with up to 2 decimal places
                break;
            case User: // For user_name (optional alias for other cases)
                filled = "^[A-Za-z0-9]{5,15}$"; // Alphanumeric, 5-15 characters
                break;
            case UserID: // For user_id
                filled = "^U\\d{3}$"; // Pattern for User ID (e.g., U123)
                break;
            case UserName: // For user_name
                filled = "^[A-Za-z0-9_]{5,20}$"; // Alphanumeric with underscores, 5-20 characters
                break;
            case UserEmail: // For user_email
                filled = "^([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,5})$"; // Email pattern
                break;
            case UserPassword: // For user_password
                filled = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"; // At least 8 characters with letters and numbers
                break;
            default:
                return false; // If no valid case is matched
        }

        Pattern pattern = Pattern.compile(filled);

        if (text != null) {
            if (text.trim().isEmpty()) {
                return false;
            }
        } else {
            return false;
        }

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }

    public static boolean setTextColor(TextFields location, TextField textField) {
        if (Regex.isTextFieldValid(location, textField.getText())) {
            textField.setStyle("-fx-text-fill: green;");
            return true;
        } else {
            textField.setStyle("-fx-text-fill: red;");
            return false;
        }
    }
}
