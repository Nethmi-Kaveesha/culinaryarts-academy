package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.EnrollmentDAO;
import lk.ijse.entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public boolean save(Enrollment enrollment, Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(enrollment);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getCurrentId() {
        // Implement logic to get the current enrollment ID if needed
        // This could be a query to get the latest ID from the database
        return null; // Placeholder; implement your logic here
    }

    public List<Enrollment> getAll(Session session) {
        Query<Enrollment> query = session.createQuery("FROM Enrollment", Enrollment.class);
        return query.getResultList();
    }

    public Enrollment findById(String id, Session session) {
        return session.get(Enrollment.class, id);
    }

    // Add other necessary methods as per your application requirements
}
