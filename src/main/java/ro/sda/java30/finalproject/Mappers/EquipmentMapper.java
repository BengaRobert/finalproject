package ro.sda.java30.finalproject.Mappers;


import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Equipment;
import ro.sda.java30.finalproject.model.EquipmentDto;

@Service
public class EquipmentMapper implements Mapper<Equipment, EquipmentDto> {

    @Override
    public Equipment mapDtoToEntity(EquipmentDto dto) {
        Equipment entity =new Equipment();
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());
        entity.setId(dto.getId());
        entity.setLevel(dto.getLevel());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setSize(dto.getSize());
        return entity;
    }

    @Override
    public EquipmentDto mapEntityToDto(Equipment entity) {
        EquipmentDto dto = new EquipmentDto();
        dto.setCategory(entity.getCategory());
        dto.setDescription(entity.getDescription());
        dto.setId(entity.getId());
        dto.setLevel(entity.getLevel());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setSize(entity.getSize());
        return dto;
    }
}
