package lk.ijse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "programs") // Specify the table name in the database
public class Program {

    @Id // Mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy for primary key
    private Long id;

    @Column(name = "program_code", unique = true, nullable = false) // Unique and non-nullable program code
    private String programCode;

    @Column(name = "program_name", nullable = false) // Non-nullable program name
    private String programName;

    @Column(name = "program_fee", nullable = false) // Non-nullable program fee
    private String programFee; // Can be String to include currency symbols

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

    public Long getId() {
        return id; // Getter for id
    }

    public void setId(Long id) {
        this.id = id; // Setter for id
    }

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
