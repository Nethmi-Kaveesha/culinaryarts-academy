package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dao.custom.impl.StudentDAOImpl;
import lk.ijse.dto.StudentDto;
import lk.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public boolean save(StudentDto studentDto) {
        return studentDAO.save(new Student(studentDto.getId(), studentDto.getName(), studentDto.getGender(), studentDto.getBirthDay(), studentDto.getEmail(), studentDto.getPhone(), studentDto.getAddress()));
    }

    @Override
    public boolean update(StudentDto studentDto) {
        return studentDAO.update(new Student(studentDto.getId(), studentDto.getName(), studentDto.getGender(), studentDto.getBirthDay(), studentDto.getEmail(), studentDto.getPhone(), studentDto.getAddress()));
    }

    @Override
    public boolean delete(StudentDto studentDto) {
        return studentDAO.delete(new Student(studentDto.getId(), null, null, null, null, null, null)); // You may want to modify this as per your requirement
    }

    @Override
    public boolean search(StudentDto studentDto) {
        // Implement the search logic if needed
        return false;
    }

    @Override
    public StudentDto searchStudent(String studentId) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> all = studentDAO.getAll();
        List<StudentDto> allStudents = new ArrayList<>();
        for (Student s : all) {
            StudentDto studentDto = new StudentDto(s.getId(), s.getName(), s.getGender(), s.getBirthDay(), s.getEmail(), s.getPhone(), s.getAddress());
            allStudents.add(studentDto);
        }
        return allStudents;
    }

    @Override
    public String generateNewId() {
        List<StudentDto> students = getAllStudents();
        int maxId = 0;

        // Determine the maximum existing ID (assuming format is "STU-<number>")
        for (StudentDto student : students) {
            String id = student.getId();
            if (id.startsWith("STU-")) {
                int currentId = Integer.parseInt(id.substring(4)); // Get the number part
                if (currentId > maxId) {
                    maxId = currentId;
                }
            }
        }

        // Generate a new ID as "STU-" + (maxId + 1)
        return "STU-" + (maxId + 1);
    }


}

