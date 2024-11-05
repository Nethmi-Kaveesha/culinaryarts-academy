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
        User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getRole(), userDto.getEmail());
        return userDAO.save(user);
    }

    @Override
    public boolean update(UserDto userDto) {
        User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getRole(), userDto.getEmail());
        return userDAO.update(user);
    }

    @Override
    public boolean delete(UserDto userDto) {
        return userDAO.delete(new User(userDto.getUserId(), null, null, null, null));
    }

    @Override
    public boolean search(UserDto userDto) {
        return false;
    }

    @Override
    public UserDto checkData(String username, String password) {
        User user = userDAO.getUserByUsernameAndPassword(username, password);
        return user != null ? new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail()) : null;
    }

    @Override
    public UserDto checkPasswordCredential(String username) {
        User user = userDAO.getUserByUsername(username);
        return user != null ? new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail()) : null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userDAO.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : allUsers) {
            userDtos.add(new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail()));
        }
        return userDtos;
    }

    @Override
    public String generateUserId() {
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
