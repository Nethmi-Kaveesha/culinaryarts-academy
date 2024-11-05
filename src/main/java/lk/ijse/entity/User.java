package lk.ijse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "user") // Specify the table name in the database
public class User {
    // Getters and Setters
    @Id
    @Column(name = "user_id", unique = true, nullable = false) // Make userId unique and non-nullable
    private String userId; // Primary Key (String)

    @Column(name = "username", nullable = false) // Non-nullable username
    private String username;

    @Column(name = "password", nullable = false) // Non-nullable password
    private String password; // Store hashed password

    @Column(name = "role", nullable = false) // Non-nullable role
    private String role; // e.g., "admin", "admissions coordinator"

    @Column(name = "email", unique = true, nullable = false) // Unique and non-nullable email
    private String email; // User email

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String userId, String username, String password, String role, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
