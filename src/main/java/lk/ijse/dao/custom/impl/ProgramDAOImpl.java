package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean save(Program program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(program);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Program program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(program);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Program program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(program);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean search(Program program) {
        return false;
    }

    @Override
    public Program search(String programCode) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<Program> query = session.createQuery("FROM Program WHERE programCode = :programCode", Program.class);
            query.setParameter("programCode", programCode);
            Program program = query.uniqueResult();
            transaction.commit();
            return program;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Program> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<Program> query = session.createQuery("FROM Program", Program.class);
            List<Program> list = query.list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Program find(String courseCode, Session session) {
        try {
            return session.createQuery("FROM Program WHERE programCode = :courseCode", Program.class)
                    .setParameter("courseCode", courseCode)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Program findByName(String programName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<Program> query = session.createQuery("FROM Program WHERE programName = :programName", Program.class);
            query.setParameter("programName", programName);
            Program program = query.uniqueResult();
            transaction.commit();
            return program;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
