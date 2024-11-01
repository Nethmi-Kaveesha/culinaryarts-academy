package lk.ijse.dao.custom.impl;

import org.hibernate.Transaction;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.UserDAO; // Change from StudentDAO to UserDAO
import lk.ijse.entity.User; // Change from Student to User
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO { // Change class name to UserDAOImpl

    public boolean save(User object) { // Change parameter type to User
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(User object) { // Change parameter type to User
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(User object) { // Change parameter type to User
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean search(User user) { // Change parameter type to User
        // Implement the search logic if needed
        return false;
    }

    @Override
    public List<User> getAll() { // Change return type to List<User>
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("from User", User.class); // Change Student to User
        List<User> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
