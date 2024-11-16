package lk.ijse.dto;

import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.time.LocalDate;

public class EnrollmentDto {

    private String enrollmentId;
    private Student student;
    private Program program; // Holds the program's name
    private LocalDate enrollmentDate;
    private String payment;
    private String duration;
    private int years;

    // Default constructor
    public EnrollmentDto() {}

    // Parameterized constructor
    public EnrollmentDto(String enrollmentId, Student student, Program program, LocalDate enrollmentDate, String payment, String duration, int years) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.program = program;
        this.enrollmentDate = enrollmentDate;
        this.payment = payment;
        this.duration = duration;
        this.years = years;
    }


    // Getters and Setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student studentName) {
        this.student = studentName;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    // Override toString() for better readability
    @Override
    public String toString() {
        return String.format("EnrollmentDto{enrollmentId='%s', studentName='%s', programName='%s', enrollmentDate=%s, payment='%s', duration='%s', years=%d}",
                enrollmentId, student, program, enrollmentDate, payment, duration, years);
    }
}
