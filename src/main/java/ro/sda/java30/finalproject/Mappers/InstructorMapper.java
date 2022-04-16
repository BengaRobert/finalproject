package ro.sda.java30.finalproject.Mappers;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Instructor;
import ro.sda.java30.finalproject.model.InstructorDto;

import java.util.Base64;

@Service
public class InstructorMapper implements Mapper<Instructor, InstructorDto> {
    @Override
    public Instructor mapDtoToEntity(InstructorDto dto) {
        Instructor entity = new Instructor();
        entity.setCertifications(dto.getCertifications());
        entity.setDescription(dto.getDescription());
        entity.setExperience(dto.getExperience());
        entity.setId(dto.getId());
        entity.setLanguages(dto.getLanguages());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPhoto(dto.getPhoto());
        return entity;
    }

    @Override
    public InstructorDto mapEntityToDto(Instructor entity) {
        InstructorDto dto = new InstructorDto();
        dto.setCertifications(entity.getCertifications());
        dto.setDescription(entity.getDescription());
        dto.setExperience(entity.getExperience());
        dto.setId(entity.getId());
        dto.setLanguages(entity.getLanguages());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPhoto(entity.getPhoto());
        dto.setPhotoBase64(Base64.getEncoder().encodeToString(entity.getPhoto()));
        return dto;
    }
}
