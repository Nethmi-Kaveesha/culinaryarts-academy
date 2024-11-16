package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.EnrollmentDetailDAO;
import lk.ijse.entity.EnrollmentDetail;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class EnrollmentDetailDAOImpl implements EnrollmentDetailDAO {
    @Override
    public boolean save(EnrollmentDetail entity) {
        return false;
    }

    @Override
    public List<EnrollmentDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(EnrollmentDetail dto) {
        return false;
    }

    @Override
    public boolean delete(EnrollmentDetail object) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean save(List<EnrollmentDetail> enrollmentDetails, Session session) {
        try {
            for (EnrollmentDetail enrollmentDetail : enrollmentDetails) {
                boolean isSaved = save(enrollmentDetail, session);
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean save(EnrollmentDetail enrollmentDetail, Session session) {
        session.save(enrollmentDetail);
        return true;
    }
}
