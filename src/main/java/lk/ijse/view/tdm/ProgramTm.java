package lk.ijse.view.tdm;

public class ProgramTm {
    private String programCode;
    private String programName;
    private String programFee;
    private String programDuration;

    @Override
    public String toString() {
        return "ProgramDto{" +
                "programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", programFee='" + programFee + '\'' +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramFee() {
        return programFee;
    }

    public void setProgramFee(String programFee) {
        this.programFee = programFee;
    }

    public String getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }

    public ProgramTm(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }

    public ProgramTm() {
    }
}
