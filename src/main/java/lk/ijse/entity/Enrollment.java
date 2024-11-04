package lk.ijse.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Enrollment {
    @Id
    private String enrollmentId;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "enrollment")
    List<EnrollmentDetails> enrollmentDetails;

    public Enrollment() {
    }

    public Enrollment(String enrollmentId, Date date, Student student, Program program, List<EnrollmentDetails> enrollmentDetails) {
        this.enrollmentId = enrollmentId;
        this.date = date;
        this.student = student;
        this.program = program;
        this.enrollmentDetails = enrollmentDetails;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", date=" + date +
                ", student=" + student +
                ", program=" + program +
                ", enrollmentDetails=" + enrollmentDetails +
                '}';
    }
}
