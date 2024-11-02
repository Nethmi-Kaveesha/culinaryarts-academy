package lk.ijse.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProgramDto {
    // Setter for programCode
    // Getters and Setters
    // Getter for programCode
    @Id
    private String programCode;    // Unique code for the program
    // Setter for programName
    // Getter for programName
    private String programName;    // Name of the program
    // Setter for programFee
    // Getter for programFee
    private String programFee;     // Fee for the program
    // Setter for programDuration
    // Getter for programDuration
    private String programDuration; // Duration of the program

    // Constructor with parameters for easy instantiation
    public ProgramDto(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }

    // No-argument constructor required for certain frameworks
    public ProgramDto() {
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "ProgramDto{" +
                "programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", programFee='" + programFee + '\'' +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }
}
