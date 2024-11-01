package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.util.List;

public interface ProgramDAO extends CrudDAO<Program> {
    boolean search(Program program);
    List<Program> getAll();
}

