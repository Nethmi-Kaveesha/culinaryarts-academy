package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User user) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // Return an empty list instead of null
        }
    }

    @Override
    public User findByUsername(String username) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM User WHERE username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            return query.uniqueResult(); // Returns null if no user found
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean search(User user) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM User WHERE username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", user.getUsername());
            return query.uniqueResult() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Uncomment the following method if you want to use it
    /*
    @Override
    public User authenticate(String username, String password) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "FROM User WHERE username = :username AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult(); // Returns null if no user found
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    */
}
