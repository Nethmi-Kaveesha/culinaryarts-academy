package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Enrollment {
    // Getters and Setters
    @Id
    private String id;  // Unique identifier for the enrollment record

    private LocalDate registrationDate;  // Date of enrollment
    private String paymentStatus;  // Status of payment (e.g., "Paid", "Pending", "Failed")

    // Many-to-One relationship with Student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)  // Foreign key column
    private Student student;

    // Many-to-One relationship with Program
    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)  // Foreign key column
    private Program program;

    // Default constructor
    public Enrollment() {}

    // Parameterized constructor
    public Enrollment(String id, LocalDate registrationDate, String paymentStatus, Student student, Program program) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.paymentStatus = paymentStatus;
        this.student = student;
        this.program = program;
    }

    // Additional methods to get the IDs
    public String getStudentId() {
        return student != null ? student.getId() : null;
    }

    public String getProgramId() {
        return program != null ? program.getProgramCode() : null; // Change to getProgramCode()
    }
}
