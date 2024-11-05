package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // Mark as a JPA entity
@Table(name = "program") // Specify table name
public class Program {

    @Id // Mark this field as the primary key
    @Column(name = "program_code") // Specify column name in the database
    private String programCode;

    @Column(name = "program_name") // Specify column name
    private String programName;

    @Column(name = "program_fee") // Specify column name
    private String programFee; // Consider using BigDecimal if you plan to do arithmetic on fee

    @Column(name = "program_duration") // Specify column name
    private String programDuration;
//
//    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Enrollment> enrollmentList;

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
                ", programFee='" + programFee + '\'' +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }
}
