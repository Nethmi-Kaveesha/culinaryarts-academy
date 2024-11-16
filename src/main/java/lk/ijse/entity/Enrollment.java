package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {

    // Enrollment ID as a reference, not the primary key
    private String enrollmentId;

    // Primary key for Enrollment entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with Student entity
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    // Many-to-One relationship with Program entity
    @ManyToOne
    @JoinColumn(name = "program_code", referencedColumnName = "program_code") // Updated to match Program primary key
    private Program program;

    // Enrollment related fields
    private LocalDate enrollmentDate; // The date when the student enrolled
    private String payment; // Payment made for the program
    private String duration; // Duration of the program
    private int years; // Number of years for the program

    // Default constructor
    public Enrollment() {}

    // Constructor for easy initialization
    public Enrollment(String enrollmentId, Student student, Program program, LocalDate enrollmentDate, String payment, String duration, int years) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.program = program;
        this.enrollmentDate = enrollmentDate;
        this.payment = payment;
        this.duration = duration;
        this.years = years;
    }




    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", id=" + id +
                ", student=" + student +
                ", program=" + program +
                ", enrollmentDate=" + enrollmentDate +
                ", payment=" + payment +
                ", duration='" + duration + '\'' +
                ", years=" + years +
                '}';
    }
}
