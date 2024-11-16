package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    public Student search(String studentId);
    List<Student> getAll();

    Student findByName(String studentName);

    Student find(String studentId, Session session);
}
