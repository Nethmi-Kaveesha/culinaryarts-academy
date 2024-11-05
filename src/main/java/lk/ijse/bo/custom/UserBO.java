package lk.ijse.bo.custom;

import lk.ijse.dto.UserDto;

import java.util.List;

public interface UserBO {
    boolean save(UserDto userDto);
    boolean update(UserDto userDto);
    boolean delete(UserDto userDto);
    boolean search(UserDto userDto); // Changed to return UserDto based on userId

    UserDto checkData(String username, String password);

    UserDto checkPasswordCredential(String username);

    List<UserDto> getAllUsers(); // Updated method name for clarity

    String generateUserId();
}
