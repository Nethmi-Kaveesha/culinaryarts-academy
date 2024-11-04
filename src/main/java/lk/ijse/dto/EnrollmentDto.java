package lk.ijse.dto;


import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.util.Date;

public class EnrollmentDto {
    private String enrollmentId;  // Unique ID for the enrollment
    private Date date;
    private Student student;
    private Program program;

    public EnrollmentDto() {
    }

    public EnrollmentDto(String enrollmentId, Date date, Student student, Program program) {
        this.enrollmentId = enrollmentId;
        this.date = date;
        this.student = student;
        this.program = program;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

}
