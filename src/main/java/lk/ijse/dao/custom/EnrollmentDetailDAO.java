package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.EnrollmentDetail;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface EnrollmentDetailDAO extends CrudDAO<EnrollmentDetail> {
    boolean save(EnrollmentDetail entity);

    List<EnrollmentDetail> getAll() throws SQLException;

    boolean update(EnrollmentDetail dto);

    boolean delete(String id);

    boolean save(List<EnrollmentDetail> enrollmentDetails, Session session);

    boolean save(EnrollmentDetail enrollmentDetail, Session session);
}
