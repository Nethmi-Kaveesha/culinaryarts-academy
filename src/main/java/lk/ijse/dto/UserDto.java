package lk.ijse.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    // Getters and Setters
    private String userId;    // User ID (String)
    private String username;   // Username
    private String password;   // Hashed password
    private String role;       // User role (e.g., "admin", "admissions coordinator")
    private String email;      // User email

    // Default constructor
    public UserDto() {
    }

    // Parameterized constructor
    public UserDto(String userId, String username, String password, String role, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
