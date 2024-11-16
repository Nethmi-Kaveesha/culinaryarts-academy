package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    private String programFee; // Using BigDecimal for financial values

    @Column(name = "program_duration")
    private String programDuration;

    // One-to-many relationship with Enrollment
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollmentList;

    // Default constructor required by JPA
    public Program() {
    }

    // Constructor with parameters for easy instantiation
    public Program(String programCode, String programName, String programFee, String programDuration) {
        this.programCode = programCode;
        this.programName = programName;
        this.programFee = programFee;
        this.programDuration = programDuration;
    }

    // Override toString method for better debugging and logging
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
