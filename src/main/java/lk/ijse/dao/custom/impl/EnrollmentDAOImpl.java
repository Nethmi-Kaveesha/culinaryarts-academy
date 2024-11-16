package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.EnrollmentDAO;
import lk.ijse.entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    @Override
    public boolean save(Enrollment object, Session session) {
        try {
            session.save(object);
            return true;
        } catch (Exception e) {
            throw e;
        }

    }


    @Override
    public boolean save(Enrollment object) {
        return false;
    }

    @Override
    public boolean update(Enrollment object) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Enrollment object) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean search(Enrollment enrollment) {
        return false;
    }

    @Override
    public List<Enrollment> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Enrollment");
        List<Enrollment> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public String getLastEnrollmentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query<String> query = session.createQuery("select e.enrollmentId from Enrollment e order by e.enrollmentId desc", String.class);
        query.setMaxResults(1);
        String lastId = query.uniqueResult();
        transaction.commit();
        session.close();
        return lastId;
    }

    @Override
    public Enrollment findById(String enrollmentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // Query to find the enrollment by the given enrollmentId
        Query<Enrollment> query = session.createQuery("from Enrollment where enrollmentId = :enrollmentId", Enrollment.class);
        query.setParameter("enrollmentId", enrollmentId);

        // Retrieve the unique result
        Enrollment enrollment = query.uniqueResult();

        transaction.commit();
        session.close();

        return enrollment;
    }

    public Object getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Query query = session.createQuery("select enrollmentId from Enrollment ORDER BY enrollmentId DESC LIMIT 1");
            Object currentId = query.uniqueResult();
            return currentId;
        } catch (Exception e) {
            return null;
        }
    }


}
