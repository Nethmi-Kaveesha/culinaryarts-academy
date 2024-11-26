package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    boolean save(UserDto userDto);
    boolean update(UserDto userDto);
    boolean delete(UserDto userDto);
    boolean search(UserDto userDto); // Changed to return UserDto based on userId



    List<UserDto> getAllUsers(); // Updated method name for clarity

    UserDto findUserByUsername(String username);


    UserDto findPositionByUserName(String username);

    String generateUserId();
}
