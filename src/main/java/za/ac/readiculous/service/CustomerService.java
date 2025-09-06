package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Customer;
import za.ac.readiculous.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Save new customer
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    // Find customer by ID
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    // Get all customers
    public List<Customer> findAll() {
        return repository.findAll();
    }

    // Update customer
    public Customer update(Customer customer) {
        if (customer.getId() == null || !repository.existsById(customer.getId())) {
            throw new IllegalArgumentException("Customer with ID " + customer.getId() + " does not exist.");
        }
        return repository.save(customer);
    }

    // Delete customer by ID
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
