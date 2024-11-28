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


    private String enrollmentId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "program_code", referencedColumnName = "program_code")
    private Program program;


    private LocalDate enrollmentDate;
    private String payment;
    private String duration;
    private int years;


    public Enrollment() {}


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
