package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDto;

import java.util.List;


public interface StudentBO extends SuperBO {
    public boolean save(StudentDto studentDto);
    public boolean update(StudentDto studentDto);
    public boolean delete(StudentDto studentDto);
    public boolean search(StudentDto studentDto);
    StudentDto searchStudent(String studentId);

    public List<StudentDto> getAllStudents();

    String generateNewId();
}
