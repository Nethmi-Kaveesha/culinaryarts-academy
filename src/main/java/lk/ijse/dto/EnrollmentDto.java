package lk.ijse.dto;

import java.time.LocalDate;

public class EnrollmentDto {
    private String enrollmentId;  // Unique ID for the enrollment
    private String studentId;      // ID of the student enrolling
    private String programCode;    // Code of the program the student is enrolling in
    private LocalDate enrollmentDate; // Date of enrollment

    // Default constructor
    public EnrollmentDto() {
    }

    // Parameterized constructor
    public EnrollmentDto(String enrollmentId, String studentId, String programCode, LocalDate enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.programCode = programCode;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "EnrollmentDto{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programCode='" + programCode + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
