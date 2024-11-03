package lk.ijse.view.tdm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentTm {

    private String id;          // Unique identifier for the student
    private String name;        // Student's name
    private String gender;      // Student's gender
    private String birthDay;    // Student's birth date as a String for display purposes
    private String email;       // Student's email address
    private String phone;       // Student's phone number
    private String address;     // Student's address

    // Constructors
    public StudentTm(String id, String name, String gender, String birthDay, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Default constructor
    public StudentTm() {
    }

    @Override
    public String toString() {
        return "StudentTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
