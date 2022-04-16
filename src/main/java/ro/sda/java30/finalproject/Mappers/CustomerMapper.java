package ro.sda.java30.finalproject.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Customer;
import ro.sda.java30.finalproject.model.CustomerDto;
@Service
public class CustomerMapper implements Mapper<Customer, CustomerDto>{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Customer mapDtoToEntity(CustomerDto dto) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return entity;
    }

    @Override
    public CustomerDto mapEntityToDto(Customer entity) {
        CustomerDto dto = new CustomerDto();
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPassword(entity.getPassword());
        return dto;
    }

}
