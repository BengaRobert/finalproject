package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Instructor;
import ro.sda.java30.finalproject.model.InstructorDto;
import ro.sda.java30.finalproject.repository.InstructorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    public InstructorDto save(InstructorDto form) {
        Instructor instructor = instructorMapper.mapDtoToEntity(form);
        instructorRepository.save(instructor);
        return instructorMapper.mapEntityToDto(instructor);
    }

    public List<InstructorDto> getAllInstructors() {
        List<Instructor> allInstructorsEntities = instructorRepository.findAll();
        return allInstructorsEntities.stream()
                .map(instructor -> instructorMapper.mapEntityToDto(instructor))
                .collect(Collectors.toList());
    }

    public InstructorDto findInstructorById(Long id) {
        Instructor instructor= instructorRepository.findById(id).orElseThrow(()-> new RuntimeException("Instructor not found"));
        return instructorMapper.mapEntityToDto(instructor);
    }
}
