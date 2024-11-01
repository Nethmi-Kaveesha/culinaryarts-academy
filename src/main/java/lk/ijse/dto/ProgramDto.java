package lk.ijse.dto;

public class ProgramDto {
    private String programCode;    // Unique code for the program
    private String programName;    // Name of the program
    private String programFee;     // Fee for the program
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

    // Getters and Setters
    public String getProgramCode() {
        return programCode; // Getter for programCode
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode; // Setter for programCode
    }

    public String getProgramName() {
        return programName; // Getter for programName
    }

    public void setProgramName(String programName) {
        this.programName = programName; // Setter for programName
    }

    public String getProgramFee() {
        return programFee; // Getter for programFee
    }

    public void setProgramFee(String programFee) {
        this.programFee = programFee; // Setter for programFee
    }

    public String getProgramDuration() {
        return programDuration; // Getter for programDuration
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration; // Setter for programDuration
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
