package za.ac.readiculous.service;

import za.ac.readiculous.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Customer createCustomer(String firstName, String lastName, String email, String password);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Optional<Customer> getCustomerByEmail(String email);

    boolean existsByEmail(String email);

    void deleteCustomer(Long id);
}
