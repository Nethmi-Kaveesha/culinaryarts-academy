package lk.ijse.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.EnrollmentBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EnrollmentDAO;
import lk.ijse.dao.custom.EnrollmentDetailDAO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.EnrollmentDetailDto;
import lk.ijse.dto.EnrollmentDto;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.EnrollmentDetail;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentBOImpl implements EnrollmentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);
    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ENROLLMENT);
    EnrollmentDetailDAO enrollmentDetailDAO = (EnrollmentDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Enrollment_Details);
//    @Override
//    public boolean save(EnrollmentDto enrollmentDto) {
//        // Retrieve Student and Program entities using enrollmentDto details
//        Student student = studentDAO.findByName(enrollmentDto.getStudentName());
//        Program program = programDAO.findByName(enrollmentDto.getProgramName());
//
//        // If student or program doesn't exist, throw an error
//        if (student == null || program == null) {
//            throw new IllegalArgumentException("Invalid student or program name provided.");
//        }
//
//        // Create new Enrollment entity
//        Enrollment enrollment = new Enrollment(
//                enrollmentDto.getEnrollmentId(),
//                student,
//                program,
//                enrollmentDto.getEnrollmentDate(),
//                enrollmentDto.getPayment(),
//                enrollmentDto.getDuration(),
//                enrollmentDto.getYears()
//        );
//
//        // Save the enrollment entity using enrollmentDAO
//        return enrollmentDAO.save(enrollment);
//    }

    @Override
    public boolean update(EnrollmentDto enrollmentDto) {
        // Retrieve the existing Enrollment by ID
        Enrollment existingEnrollment = enrollmentDAO.findById(enrollmentDto.getEnrollmentId());

        if (existingEnrollment != null) {
            // Update existing enrollment properties
            existingEnrollment.setEnrollmentDate(enrollmentDto.getEnrollmentDate());
            existingEnrollment.setPayment(enrollmentDto.getPayment());
            existingEnrollment.setDuration(enrollmentDto.getDuration());
            existingEnrollment.setYears(enrollmentDto.getYears());

            // Save updated enrollment
            return enrollmentDAO.update(existingEnrollment);
        } else {
            throw new IllegalArgumentException("Enrollment not found for update.");
        }
    }

    @Override
    public boolean delete(EnrollmentDto enrollmentDto) {
        // Find the Enrollment by ID and delete it if it exists
        Enrollment enrollment = enrollmentDAO.findById(enrollmentDto.getEnrollmentId());
        if (enrollment != null) {
            return enrollmentDAO.delete(enrollment);
        } else {
            throw new IllegalArgumentException("Enrollment not found for deletion.");
        }
    }

    @Override
    public boolean search(EnrollmentDto enrollmentDto) {
        // Check if an Enrollment with the given ID exists
        Enrollment enrollment = enrollmentDAO.findById(enrollmentDto.getEnrollmentId());
        return enrollment != null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDAO.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getGender(), student.getBirthDay(), student.getEmail(), student.getPhone(), student.getAddress());
            studentDtos.add(studentDto);
        }
        return studentDtos;

    }

    @Override
    public String generateNewId() {
        // Generate a new ID using a specific pattern or logic
        String lastId = enrollmentDAO.getLastEnrollmentId();
        if (lastId != null) {
            int newId = Integer.parseInt(lastId.replace("E", "")) + 1;
            return "E" + newId;
        } else {
            return "E001"; // Start with E001 if there are no existing records
        }
    }

    @Override
    public Object currentId() {

        return enrollmentDAO.getCurrentId();
    }

    @Override
    public void registerEnrollment(EnrollmentDto enrollmentDTO, List<EnrollmentDetailDto> enrollmentDetailList) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction(); // Begin transaction

        try {
            // Create an Enrollment entity from EnrollmentDTO
            Enrollment enrollment = new Enrollment(
                    enrollmentDTO.getEnrollmentId(),
                    enrollmentDTO.getStudent(),       // Assuming it returns a Student entity
                    enrollmentDTO.getProgram(),       // Assuming it returns a Program entity
                    enrollmentDTO.getEnrollmentDate(),
                    enrollmentDTO.getPayment(),
                    enrollmentDTO.getDuration(),
                    enrollmentDTO.getYears()
            );

            // Save the Enrollment entity
            boolean isSaved = enrollmentDAO.save(enrollment, session);

            if (isSaved) {
                // Prepare list of EnrollmentDetail entities
                List<EnrollmentDetail> enrollmentDetails = new ArrayList<>();

                for (EnrollmentDetailDto detailDto : enrollmentDetailList) {
                    // Fetch Program and Student entities using their IDs or codes
                    Program program = programDAO.find(detailDto.getCourseCode(), session); // Assuming courseCode maps to Program
                    Student student = studentDAO.find(detailDto.getStudentId(), session);  // Assuming studentId maps to Student

                    // Create EnrollmentDetail object
                    EnrollmentDetail enrollmentDetail = new EnrollmentDetail(
                            enrollment,                // Enrollment entity (already created earlier)
                            program,                   // Program entity fetched from DB
                            student,                   // Student entity fetched from DB
                            detailDto.getEnrollmentDate()
                    );

                    // Add the new enrollment detail to the list
                    enrollmentDetails.add(enrollmentDetail);
                }

                // Save the list of EnrollmentDetail entities
                for (EnrollmentDetail enrollmentDetail : enrollmentDetails) {
                    enrollmentDetailDAO.save(enrollmentDetail, session); // Save each detail
                }

                transaction.commit(); // Commit transaction if everything is successful
                new Alert(Alert.AlertType.CONFIRMATION, "Transaction completed!").show();
            }

        } catch (Exception e) {
            transaction.rollback(); // Rollback transaction in case of any exception
            throw e; // Re-throw the exception to handle it at a higher level

        } finally {
            session.close(); // Close session to release resources
        }
    }

}
