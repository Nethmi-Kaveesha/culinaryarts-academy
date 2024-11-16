package lk.ijse.dto;

import java.time.LocalDate;

public class EnrollmentDetailDto {

    private String enrollmentId;
    private String courseCode;
    private String studentId;
    private LocalDate enrollmentDate; // Changed to LocalDate

    // Constructor
    public EnrollmentDetailDto(String enrollmentId, String courseCode, String studentId, LocalDate enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
    }


    // Getters and Setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    // toString() method for easy printing
    @Override
    public String toString() {
        return "EnrollmentDetailDto{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", studentId='" + studentId + '\'' +
                ", enrollmentDate=" + enrollmentDate +  // LocalDate will be formatted automatically
                '}';
    }
}
