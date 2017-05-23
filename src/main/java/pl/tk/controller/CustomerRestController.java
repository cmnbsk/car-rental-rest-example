package pl.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tk.model.Customer;
import pl.tk.repository.CustomerRepository;

import java.util.List;

/**
 * Created by Tobiasz on 2017-05-22.
 */

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public ResponseEntity<List<Customer>> listAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        Customer currentCustomer = customerRepository.findOne(id);
        if(currentCustomer == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(currentCustomer);

        return new ResponseEntity<>(currentCustomer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        Customer currentCustomer = customerRepository.findOne(id);
        if(currentCustomer == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        customerRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers")
    public ResponseEntity<?> deleteAllCustomers(){
        customerRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
