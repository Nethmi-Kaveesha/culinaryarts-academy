package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dao.custom.impl.UserDAOImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean save(UserDto userDto) {
        // Convert UserDto to User entity and save
        User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getRole(), userDto.getEmail());
        return userDAO.save(user);
    }

    @Override
    public boolean update(UserDto userDto) {
        // Convert UserDto to User entity and update
        User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getRole(), userDto.getEmail());
        return userDAO.update(user);
    }

    @Override
    public boolean delete(UserDto userDto) {
        // Use userId for deletion
        return userDAO.delete(new User(userDto.getUserId(), null, null, null, null));
    }

    @Override
    public boolean search(UserDto userDto) {
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Retrieve all users and convert to UserDto list
        List<User> allUsers = userDAO.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : allUsers) {
            userDtos.add(new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail()));
        }
        return userDtos;
    }

    @Override
    public String generateUserId() {
        // Assuming you have a method to get all users
        List<UserDto> userList = getAllUsers();
        int maxId = 0;

        for (UserDto user : userList) {
            int currentId = Integer.parseInt(user.getUserId());
            if (currentId > maxId) {
                maxId = currentId;
            }
        }

        return String.valueOf(maxId + 1); // Generate next ID
    }
}
