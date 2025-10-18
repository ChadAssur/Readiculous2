package za.ac.readiculous.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Customer;
import za.ac.readiculous.factory.CustomerFactory;
import za.ac.readiculous.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create new customer (default role USER)
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = CustomerFactory.createCustomer(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(newCustomer));
    }

    // Create admin customer
    @PostMapping("/admin")
    public ResponseEntity<Customer> createAdmin(@RequestBody Customer customer) {
        Customer newAdmin = CustomerFactory.createAdmin(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(newAdmin));
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {   // <-- change Integer -> Long
        Optional<Customer> customer = customerService.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    // Update customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {  // <-- change Integer -> Long
        Optional<Customer> existing = customerService.findById(id);
        if (existing.isPresent()) {
            Customer customer = new Customer.Builder()
                    .copy(existing.get())
                    .SetfirstName(updatedCustomer.getFirstName())
                    .SetlastName(updatedCustomer.getLastName())
                    .SetEmail(updatedCustomer.getEmail())
                    .SetPassword(updatedCustomer.getPassword())
                    .SetRole(updatedCustomer.getRole())
                    .build();

            return ResponseEntity.ok(customerService.update(customer));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {   // <-- change Integer -> Long
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
