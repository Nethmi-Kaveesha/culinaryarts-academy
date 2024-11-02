package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "programs") // Specify the table name in the database
public class Program {

    // Setter for id
    // Getter for id
    @Id // Mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy for primary key
    private Long id;

    // Setter for programCode
    // Getter for programCode
    @Column(name = "program_code", unique = true, nullable = false) // Unique and non-nullable program code
    private String programCode;

    // Setter for programName
    // Getter for programName
    @Column(name = "program_name", nullable = false) // Non-nullable program name
    private String programName;

    // Setter for programFee
    // Getter for programFee
    @Column(name = "program_fee", nullable = false) // Non-nullable program fee
    private String programFee; // Can be String to include currency symbols

    // Setter for programDuration
    // Getter for programDuration
    @Column(name = "program_duration", nullable = false) // Non-nullable program duration
    private String programDuration;

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

    // Getters and Setters for all fields

    // Override toString method for better debugging and logging
    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", programFee='" + programFee + '\'' +
                ", programDuration='" + programDuration + '\'' +
                '}';
    }
}
