package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    boolean search(User user); // Search for a user based on the User object

    User getUserByUsernameAndPassword(String username, String password);

    User getUserByUsername(String username);

    List<User> getAll(); // Retrieve all users

    User authenticate(String username, String password); // Validate user credentials

    User findByUsername(String username); // Find a user by username
}
