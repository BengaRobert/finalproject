package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.Mappers.EquipmentMapper;
import ro.sda.java30.finalproject.entities.Equipment;
import ro.sda.java30.finalproject.model.EquipmentDto;
import ro.sda.java30.finalproject.repository.EquipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }


    public EquipmentDto save(EquipmentDto form) {
        Equipment equipment = equipmentMapper.mapDtoToEntity(form);
        equipmentRepository.save(equipment);
        return equipmentMapper.mapEntityToDto(equipment);
    }

    public List<EquipmentDto> getAllEquipment() {
        List<Equipment> allEquipmentEntities = equipmentRepository.findAll();
        return allEquipmentEntities.stream()
                .map(equipment -> equipmentMapper.mapEntityToDto(equipment))
                .collect(Collectors.toList());
    }

    public EquipmentDto findEquipmentById(Long id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
        return equipmentMapper.mapEntityToDto(equipment);
    }

    public void deleteEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
        equipmentRepository.delete(equipment);
    }
}
