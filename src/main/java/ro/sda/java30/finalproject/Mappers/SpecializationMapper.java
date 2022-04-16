package ro.sda.java30.finalproject.Mappers;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Specialization;
import ro.sda.java30.finalproject.model.SpecializationDto;
@Service
public class SpecializationMapper implements Mapper<Specialization, SpecializationDto> {

    @Override
    public Specialization mapDtoToEntity(SpecializationDto dto) {
        Specialization entity = new Specialization();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public SpecializationDto mapEntityToDto(Specialization entity) {
        SpecializationDto dto = new SpecializationDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
