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
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userDAO.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : allUsers) {
            userDtos.add(new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail()));
        }
        return userDtos;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        User user = userDAO.findByUsername(username);  // Assuming the DAO method is implemented to find user by username
        if (user != null) {
            return new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
        }
        return null;  // Return null if user not found
    }


    @Override
    public UserDto findPositionByUserName(String username) {
        User user = userDAO.findByUsername(username);  // Assuming the DAO method is implemented to find user by username
        if (user != null) {
            return new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
        }
        return null;  // Return null if user not found
    }


    @Override
    public String generateUserId() {
        List<UserDto> userList = getAllUsers();
        int maxId = 0;
        String prefix = "user_";

        // Loop through all users and extract the numeric part of the userId
        for (UserDto user : userList) {
            try {
                // Extract the numeric part after the prefix (e.g., "user_001" -> 1)
                String numericPart = user.getUserId().replace(prefix, "");
                int currentId = Integer.parseInt(numericPart);
                if (currentId > maxId) {
                    maxId = currentId;
                }
            } catch (NumberFormatException e) {
                // Handle invalid userId format if necessary
                System.out.println("Invalid userId format for user: " + user.getUserId());
            }
        }

        // Generate the next userId with the prefix
        return prefix + String.format("%03d", maxId + 1); // This will pad with leading zeros
    }

}
