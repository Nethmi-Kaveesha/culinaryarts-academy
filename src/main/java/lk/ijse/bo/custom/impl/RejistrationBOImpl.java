//package lk.ijse.bo.custom.impl;
//
//import javafx.scene.control.Alert;
//import lk.ijse.bo.custom.RejistrationBO;
//import lk.ijse.config.FactoryConfiguration;
//import lk.ijse.dao.DAOFactory;
//import lk.ijse.dao.custom.EnrollmentDAO;
//import lk.ijse.dao.custom.EnrollmentDetailsDAO;
//import lk.ijse.dao.custom.ProgramDAO;
//import lk.ijse.dao.custom.StudentDAO;
//import lk.ijse.dto.EnrollmentDetailsDto;
//import lk.ijse.dto.EnrollmentDto;
//import lk.ijse.dto.ProgramDto;
//import lk.ijse.dto.StudentDto;
//import lk.ijse.entity.Enrollment;
//import lk.ijse.entity.EnrollmentDetails;
//import lk.ijse.entity.Program;
//import lk.ijse.entity.Student;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RejistrationBOImpl implements RejistrationBO {
//
//    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);
//    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
//    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ENROLLMENT);
//    EnrollmentDetailsDAO enrollmentDetailsDAO = (EnrollmentDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ENROLLMENTDETAILS);
//
//    @Override
//    public List<ProgramDto> getAllItems() throws SQLException {
//        List<Program> programs = programDAO.getAll();
//        List<ProgramDto> programDtos = new ArrayList<>();
//
//        for (Program program : programs) {
//            ProgramDto programDto = new ProgramDto(program.getProgramCode(),program.getProgramName(),program.getProgramFee(),program.getProgramDuration());
//            programDtos.add(programDto);
//        }
//        return programDtos;
//    }
//
//    @Override
//    public List<StudentDto> getAllCustomers() throws SQLException {
//        List<Student> students = studentDAO.getAll();
//        List<StudentDto> studentDtos = new ArrayList<>();
//
//        for (Student student : students) {
//            StudentDto studentDto = new StudentDto(student.getId(),student.getName(),student.getGender(),student.getBirthDay(),student.getEmail(),student.getPhone(),student.getAddress());
//            studentDtos.add(studentDto);
//
//        }
//        return studentDtos;
//    }
//
//    @Override
//    public void placeOrder(EnrollmentDto enrollmentDto, List<EnrollmentDetailsDto> enrollmentDetailsDtoList) throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        boolean isUpdated = false;
//
//        try {
//            Enrollment enrollment = new Enrollment(
//                    enrollmentDto.getEnrollmentId(),
//                    enrollmentDto.getDate(),
//                    enrollmentDto.getStudent(),
//                    new ArrayList<>() // Assuming enrollmentDetails is empty initially
//            );
//
//            boolean isSaved = enrollmentDAO.save(enrollment, session);
//
//            if (isSaved) {
//                List<EnrollmentDetails> enrollmentDetails = new ArrayList<>();
//
//                for (EnrollmentDetailsDto enrollmentDetailsDto : enrollmentDetailsDtoList) {
//                    Program program = new Program();
//                    program.setProgramCode(enrollmentDetailsDto.getProgramCode());
//                    System.out.println(program);
//
//                }
//
//                if (isUpdated) {
//                    enrollmentDetailsDAO.save(enrollmentDetails, session);
//                    transaction.commit();
//                    new Alert(Alert.AlertType.CONFIRMATION, "Transaction complete").show();
//                }
//            }
//        } catch (Exception e) {
//            transaction.rollback();
//            throw e;
//
//        } finally {
//            session.close();
//        }
//    }
//
//
//    @Override
//    public Object currentId() {
//       return enrollmentDAO.getCurrentId();
//    }
//}
