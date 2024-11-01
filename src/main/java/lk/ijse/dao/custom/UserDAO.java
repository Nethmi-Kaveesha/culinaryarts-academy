package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User; // Change from Student to User

import java.util.List;

public interface UserDAO extends CrudDAO<User> { // Change interface name to UserDAO
    boolean search(User user); // Change parameter type to User
    List<User> getAll(); // This remains the same, as it will return a list of User
}
