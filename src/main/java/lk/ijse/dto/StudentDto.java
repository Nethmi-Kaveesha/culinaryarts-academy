package lk.ijse.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StudentDto {

    private String id;           // Unique identifier for the student
    private String name;         // Student's name
    private String gender;       // Student's gender
    private LocalDate birthDay;  // Student's birth date
    private String email;        // Student's email
    private String phone;        // Student's phone number
    private String address;      // Student's address

    // Default constructor
    public StudentDto() {}

    // Parameterized constructor
    public StudentDto(String id, String name, String gender, LocalDate birthDay, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
