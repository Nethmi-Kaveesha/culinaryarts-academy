//package lk.ijse.dao.custom.impl;
//
//import lk.ijse.dao.custom.EnrollmentDetailsDAO;
//import lk.ijse.entity.EnrollmentDetails;
//import org.hibernate.Session;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class EnrollmentDetailDAOImpl implements EnrollmentDetailsDAO {
//
//    @Override
//    public boolean save(List<EnrollmentDetails> enrollmentDetails, Session session) {
//        try {
//            for (EnrollmentDetails enrollmentDetails1 : enrollmentDetails){
//                boolean isSaved = save(enrollmentDetails,session);
//            }
//            return true;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    @Override
//    public boolean save(EnrollmentDetails enrollmentDetails, Session session) {
//        return false;
//    }
//
//    @Override
//    public boolean save(Object object) {
//        return false;
//    }
//
//    @Override
//    public boolean update(Object object) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(Object object) {
//        return false;
//    }
//
//}
