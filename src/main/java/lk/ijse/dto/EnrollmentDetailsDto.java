//package lk.ijse.dto;
//
//import java.math.BigDecimal;
//
//public class EnrollmentDetailsDto {
//    private String enrollmentId; // Foreign key for Enrollment
//    private String programCode; // Foreign key for Program
//
//    private BigDecimal programFee; // Program fee
//
//    // Default constructor
//    public EnrollmentDetailsDto() {
//    }
//
//    // Parameterized constructor
//    public EnrollmentDetailsDto(String enrollmentId, String programCode, BigDecimal programFee) {
//        this.enrollmentId = enrollmentId;
//        this.programCode = programCode;
//        this.programFee = programFee;
//    }
//
//
//
//
//    public String getEnrollmentId() {
//        return enrollmentId;
//    }
//
//    public void setEnrollmentId(String enrollmentId) {
//        this.enrollmentId = enrollmentId;
//    }
//
//    public String getProgramCode() {
//        return programCode;
//    }
//
//    public void setProgramCode(String programCode) {
//        this.programCode = programCode;
//    }
//
//    public BigDecimal getProgramFee() {
//        return programFee;
//    }
//
//    public void setProgramFee(BigDecimal programFee) {
//        this.programFee = programFee;
//    }
//
//    @Override
//    public String toString() {
//        return "EnrollmentDetailsDto{" +
//                ", enrollmentId='" + enrollmentId + '\'' +
//                ", programCode='" + programCode + '\'' +
//                ", programFee=" + programFee +
//                '}';
//    }
//}
