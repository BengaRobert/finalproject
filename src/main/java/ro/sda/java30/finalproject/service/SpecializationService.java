package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.Mappers.SpecializationMapper;
import ro.sda.java30.finalproject.entities.Specialization;
import ro.sda.java30.finalproject.model.SpecializationDto;
import ro.sda.java30.finalproject.repository.SpecializationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;
    private final SpecializationMapper specializationMapper;

    public SpecializationService(SpecializationRepository specializationRepository, SpecializationMapper specializationMapper) {
        this.specializationRepository = specializationRepository;
        this.specializationMapper = specializationMapper;
    }

    public SpecializationDto save(SpecializationDto from) {
        Specialization specialization = specializationMapper.mapDtoToEntity(from);
        specializationRepository.save(specialization);
        return specializationMapper.mapEntityToDto(specialization);
    }

    public Object getAllSpecializations() {
        List<Specialization> allSpecializationsEntities = specializationRepository.findAll();
        return allSpecializationsEntities.stream()
                .map(specialization -> specializationMapper.mapEntityToDto(specialization))
                .collect(Collectors.toList());
    }

    public SpecializationDto findSpecializationById(Long id) {
        Specialization specialization= specializationRepository.findById(id).orElseThrow(()-> new RuntimeException("Specialization not Found"));
        return specializationMapper.mapEntityToDto(specialization);
    }

    public void deleteSpecialization(Long id) {
        Specialization specialization = specializationRepository.findById(id).orElseThrow(()->new RuntimeException("Specialization not found"));
        specializationRepository.delete(specialization);
    }
}

