package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.dto.ProgramDto;
import lk.ijse.entity.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    // Using ProgramDAO for database operations
    ProgramDAO programDAO = new ProgramDAOImpl();

    @Override
    public boolean save(ProgramDto programDto) {
        // Saving a new Program object using the DAO
        return programDAO.save(new Program(
                programDto.getProgramCode(),
                programDto.getProgramName(),
                programDto.getProgramFee(),
                programDto.getProgramDuration()));
    }

    @Override
    public boolean update(ProgramDto programDto) {
        // Updating an existing Program object
        return programDAO.update(new Program(
                programDto.getProgramCode(),
                programDto.getProgramName(),
                programDto.getProgramFee(),
                programDto.getProgramDuration()));
    }

    @Override
    public boolean delete(ProgramDto programDto) {
        // Only passing the programCode for deletion, as the other fields are not needed
        return programDAO.delete(new Program(programDto.getProgramCode(), null, null, null));
    }

    @Override
    public ProgramDto search(String programCode) {
        return null;
    }

    @Override
    public List<ProgramDto> getAllPrograms() {
        // Getting all programs from the DAO and converting them to DTOs
        List<Program> allPrograms = programDAO.getAll();
        List<ProgramDto> programDtoList = new ArrayList<>();

        // Converting Program entities to ProgramDto objects
        for (Program program : allPrograms) {
            ProgramDto programDto = new ProgramDto(
                    program.getProgramCode(),
                    program.getProgramName(),
                    program.getProgramFee(),
                    program.getProgramDuration());
            programDtoList.add(programDto);
        }

        return programDtoList;
    }
}
