package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "program_code")
    private String programCode;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "program_fee")
    private String programFee;

    @Column(name = "program_duration")
    private String programDuration;


    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollmentList;


    public Program() {
    }


    public Program(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }


    @Override
    public String toString() {
        return "Program{" +
                "programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", programFee=" + programFee +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }
}
