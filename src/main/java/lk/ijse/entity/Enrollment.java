//package lk.ijse.entity;
//
//
//import jakarta.persistence.*;
//
//
//import java.util.Date;
//import java.util.List;
//
//@Entity
//public class Enrollment {
//    @Id
//    private String enrollmentId;
//
//    private Date date;
//
////    @ManyToOne
////    @JoinColumn(name = "student_id")
////    private Student student;
//
//
//    @OneToMany(mappedBy = "enrollment")
//    List<EnrollmentDetails> enrollmentDetails;
//
//    public Enrollment() {
//    }
//
//    public Enrollment(String enrollmentId, Date date, Student student, List<EnrollmentDetails> enrollmentDetails) {
//        this.enrollmentId = enrollmentId;
//        this.date = date;
//        //this.student = student;
//        this.enrollmentDetails = enrollmentDetails;
//    }
//
//    @Override
//    public String toString() {
//        return "Enrollment{" +
//                "enrollmentId='" + enrollmentId + '\'' +
//                ", date=" + date +
//               // ", student=" + student +
//                ", enrollmentDetails=" + enrollmentDetails +
//                '}';
//    }
//}
