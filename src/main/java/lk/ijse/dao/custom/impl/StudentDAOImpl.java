package lk.ijse.dao.custom.impl;

import org.hibernate.Transaction;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    public boolean save(Student object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }


    public boolean update(Student object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(Student object) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String studentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student where id =?1");
        query.setParameter(1, studentId);
        Student student = (Student) query.uniqueResult();
        transaction.commit();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query<Student> query = session.createQuery("from Student", Student.class);
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Student findByName(String studentName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = null;

        try {
            Query<Student> query = session.createQuery("from Student where name = :studentName", Student.class);
            query.setParameter("studentName", studentName);
            student = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return student;
    }

    @Override
    public Student find(String studentId, Session session) {
        try {
            // Use Hibernate session to fetch the Student entity by studentId
            return session.createQuery("FROM Student WHERE id = :studentId", Student.class)
                    .setParameter("studentId", studentId)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of any exception
        }
    }


}
