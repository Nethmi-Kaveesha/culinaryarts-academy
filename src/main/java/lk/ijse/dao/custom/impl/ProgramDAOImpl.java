package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    public boolean save(Program object){
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Program object){
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(Program object){
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public boolean search(Program program) {
        return false;
    }

    @Override
    public Program search(String itemCode) throws SQLException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Program where programCode =?1");
        query.setParameter(1, itemCode);
        Program program = (Program) query.uniqueResult();
        transaction.commit();
        return program;
    }
    @Override
    public List<Program> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Program");
        List<Program> list = query.list();

        transaction.commit();
        session.close();

        return list;

    }

    @Override
    public Program find(String courseCode, Session session) {
        try {
            // Use Hibernate session to fetch the Program entity by courseCode
            return session.createQuery("FROM Program WHERE programCode = :courseCode", Program.class)
                    .setParameter("courseCode", courseCode)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of any exception
        }
    }


    @Override
    public Program findByName(String programName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Program program = null;

        try {
            Query<Program> query = session.createQuery("from Program where programName = :programName", Program.class);
            query.setParameter("programName", programName);
            program = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return program;
    }

}


