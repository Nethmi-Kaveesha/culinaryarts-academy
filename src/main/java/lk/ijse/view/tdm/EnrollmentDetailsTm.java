//package lk.ijse.view.tdm;
//
//import java.time.LocalDate;
//
//public class EnrollmentDetailsTm {
//    private String id; // Enrollment ID
//    private String studentId; // Corresponding Student ID
//    private String studentName; // Student Name (optional for display)
//    private String programId; // Corresponding Program ID
//    private String programName; // Program Name (optional for display)
//    private LocalDate registrationDate; // Date of enrollment
//    private String paymentStatus; // Payment status (e.g., "Paid", "Pending", "Failed")
//
//    // Default constructor
//    public EnrollmentDetailsTm() {
//    }
//
//    // Parameterized constructor
//    public EnrollmentDetailsTm(String id, String studentId, String studentName, String programId, String programName, LocalDate registrationDate, String paymentStatus) {
//        this.id = id;
//        this.studentId = studentId;
//        this.studentName = studentName;
//        this.programId = programId;
//        this.programName = programName;
//        this.registrationDate = registrationDate;
//        this.paymentStatus = paymentStatus;
//    }
//
//    // Getters and Setters
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getProgramId() {
//        return programId;
//    }
//
//    public void setProgramId(String programId) {
//        this.programId = programId;
//    }
//
//    public String getProgramName() {
//        return programName;
//    }
//
//    public void setProgramName(String programName) {
//        this.programName = programName;
//    }
//
//    public LocalDate getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDate registrationDate) {
//        this.registrationDate = registrationDate;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "EnrollmentDetailsTm{" +
//                "id='" + id + '\'' +
//                ", studentId='" + studentId + '\'' +
//                ", studentName='" + studentName + '\'' +
//                ", programId='" + programId + '\'' +
//                ", programName='" + programName + '\'' +
//                ", registrationDate=" + registrationDate +
//                ", paymentStatus='" + paymentStatus + '\'' +
//                '}';
//    }
//}
