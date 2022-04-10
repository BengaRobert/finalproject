package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Instructor;
import ro.sda.java30.finalproject.model.InstructorDto;
import ro.sda.java30.finalproject.repository.InstructorRepository;

@Service

public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    public InstructorDto save(InstructorDto form) {
        Instructor instructor=instructorMapper.mapDtoToEntity(form);
        instructorRepository.save(instructor);
        return instructorMapper.mapEntityToDto(instructor);
    }
}
