package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ProgramDto;
import lk.ijse.entity.Program;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBO extends SuperBO {
    boolean save(ProgramDto programDto);
    boolean update(ProgramDto programDto);
    boolean delete(ProgramDto programDto);
    Program search(String programCode) throws SQLException; // Assuming searching by program code returns a ProgramDto

    List<ProgramDto> getAllPrograms(); // Changed method name for clarity


}
