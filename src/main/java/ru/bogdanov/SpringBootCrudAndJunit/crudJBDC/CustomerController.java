package ru.bogdanov.SpringBootCrudAndJunit.crudJBDC;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Long create(@RequestBody Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    @GetMapping
    public Customer getCustomerById(@RequestParam long id) {
        return customerRepository.getCustomerById(id);
    }

    @PutMapping
    public void editCustomer(@RequestBody Customer customer) {
        customerRepository.editCustomer(customer);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam long id) {
        customerRepository.deleteCustomer(id);
    }
}
