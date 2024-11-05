package lk.ijse.dao.custom.impl;

import org.hibernate.Transaction;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    @Override
    public boolean delete(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM User WHERE username = :username AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult(); // Returns null if no result found
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM User WHERE username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            return query.uniqueResult(); // Returns null if no result found
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.list(); // Returns an empty list if no results found
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return null; // Or return an empty list depending on your design choice
        }
    }

    @Override
    public User authenticate(String username, String password) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public boolean search(User user) {
        // Implement the search logic if needed
        return false; // Implement this method if searching is required
    }
}
