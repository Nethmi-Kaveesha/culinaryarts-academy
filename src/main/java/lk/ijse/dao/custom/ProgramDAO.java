package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface ProgramDAO extends CrudDAO<Program> {
    boolean search(Program program);

    Program search(String itemCode) throws SQLException;

    List<Program> getAll();


    Program findByName(String programName);

    Program find(String courseCode, Session session);
}

