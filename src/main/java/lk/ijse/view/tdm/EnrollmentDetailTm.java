package lk.ijse.view.tdm;

import java.time.LocalDate;

public class EnrollmentDetailTm {
    private String enrollmentId;
    private String studentId; // Student's unique identifier
    private String studentName; // Student's name
    private String programId; // Program's unique identifier
    private String programName; // Program's name
    private LocalDate enrollmentDate; // Date of enrollment
    private String payment; // Payment made for the program
    private String duration; // Duration of the program
    private int years; // Number of years for the program

    // Default constructor
    public EnrollmentDetailTm() {}

    // Constructor to initialize EnrollmentTm with enrollment data
    public EnrollmentDetailTm(String enrollmentId,String studentId, String studentName, String programId, String programName,
                        LocalDate enrollmentDate, String payment, String duration, int years) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.programId = programId;
        this.programName = programName;
        this.enrollmentDate = enrollmentDate;
        this.payment = payment;
        this.duration = duration;
        this.years = years;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    // Getter and Setter methods for each field
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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

    // Optional: Override toString() method to display the EnrollmentTm details in a human-readable format
    @Override
    public String toString() {
        return "EnrollmentTm{" +
                "enrollmentId='" + enrollmentId + '\'' +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", payment=" + payment +
                ", duration='" + duration + '\'' +
                ", years=" + years +
                '}';
    }
}
