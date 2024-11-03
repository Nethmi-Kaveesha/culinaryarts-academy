package lk.ijse.view.tdm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProgramTm {
    private String programCode;      // Unique identifier for the program
    private String programName;      // Name of the program
    private String programFee;       // Fee for the program
    private String programDuration;   // Duration of the program

    // Parameterized constructor
    public ProgramTm(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }

    // Default constructor
    public ProgramTm() {
    }

    @Override
    public String toString() {
        return "ProgramTm{" +
                "programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", programFee='" + programFee + '\'' +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }
}
