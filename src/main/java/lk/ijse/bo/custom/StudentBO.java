package lk.ijse.bo.custom;

import lk.ijse.dto.StudentDto;

import java.util.List;


public interface StudentBO {
    public boolean save(StudentDto studentDto);
    public boolean update(StudentDto studentDto);
    public boolean delete(StudentDto studentDto);
    public boolean search(StudentDto studentDto);

    public List<StudentDto> getAllStudents();

    String generateNewId();
}
