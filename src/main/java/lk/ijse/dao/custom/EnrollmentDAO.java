package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Program;
import org.hibernate.Session;

import java.util.List;

public interface EnrollmentDAO extends CrudDAO<Enrollment> {
    boolean save(Enrollment object, Session session);

    boolean search(Enrollment enrollment);
    List<Enrollment> getAll();

    String getLastEnrollmentId();

    Enrollment findById(String enrollmentId);

    Object getCurrentId();
}
