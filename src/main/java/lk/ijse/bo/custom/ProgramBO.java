package lk.ijse.bo.custom;

import lk.ijse.dto.ProgramDto;

import java.util.List;

public interface ProgramBO {
    boolean save(ProgramDto programDto);
    boolean update(ProgramDto programDto);
    boolean delete(ProgramDto programDto);
    ProgramDto search(String programCode); // Assuming searching by program code returns a ProgramDto

    List<ProgramDto> getAllPrograms(); // Changed method name for clarity
}
