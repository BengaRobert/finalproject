package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.Mappers.CustomerMapper;
import ro.sda.java30.finalproject.entities.Customer;
import ro.sda.java30.finalproject.model.CustomerDto;
import ro.sda.java30.finalproject.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto save(CustomerDto form) {
        Customer customer = customerMapper.mapDtoToEntity(form);
        customerRepository.save(customer);
        return customerMapper.mapEntityToDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomerEntities = customerRepository.findAll();
        return allCustomerEntities.stream()
                .map(customer -> customerMapper.mapEntityToDto(customer))
                .collect(Collectors.toList());
    }

    public CustomerDto findProductById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.mapEntityToDto(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }
}
