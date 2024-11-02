package lk.ijse.view.tdm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProgramTm {
    @Id
    private String programCode;
    private String programName;
    private String programFee;
    private String programDuration;

   

    public ProgramTm(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }

    public ProgramTm() {
    }
}
