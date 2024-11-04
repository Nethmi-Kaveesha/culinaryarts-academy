package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.EnrollmentDetails;
import org.hibernate.Session;

import java.util.List;

public interface EnrollmentDetailsDAO extends CrudDAO {
    public boolean save(List<EnrollmentDetails> enrollmentDetails, Session session);
    public boolean save(EnrollmentDetails enrollmentDetails,Session session);
}