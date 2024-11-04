package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "programs") // Specify the table name in the database
public class Program {

    @Id // Mark this field as the primary key

    private String programCode;


    private String programName;


    private String programFee; // Can be String to include currency symbols


    private String programDuration;

    @OneToMany(mappedBy = "program")
    List<EnrollmentDetails> enrollmentDetails;

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
