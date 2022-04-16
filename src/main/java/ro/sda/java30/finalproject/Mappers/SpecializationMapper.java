package ro.sda.java30.finalproject.Mappers;

import ro.sda.java30.finalproject.entities.Specialization;
import ro.sda.java30.finalproject.model.SpecializationDto;

public class SpecializationMapper implements Mapper<Specialization, SpecializationDto> {
    @Override
    public Specialization mapDtoToEntity(SpecializationDto dto) {
        Specialization entity = new Specialization();
        entity.setId(dto.getId());
        entity.setSki(dto.getSki());
        entity.setSnowboard(dto.getSnowboard());
        entity.setSkiSnowboard(dto.getSkiSnowboard());
        return entity;
    }

    @Override
    public SpecializationDto mapEntityToDto(Specialization entity) {
        SpecializationDto dto = new SpecializationDto();
        dto.setId(entity.getId());
        dto.setSki(entity.getSki());
        dto.setSnowboard(entity.getSnowboard());
        dto.setSkiSnowboard(entity.getSkiSnowboard());

        return dto;
    }
}
