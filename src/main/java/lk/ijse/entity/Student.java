package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    private String id;
    private String name;
    private String gender;
    @Column(name = "birth_day")
    private LocalDate birthDay;
    private String email;
    private String phone;
    private String address;

//   @OneToMany(mappedBy = "student")
//    private List<Enrollment> enrollmentList;


    public Student() {}


    public Student(String id, String name, String gender, LocalDate birthDay, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
