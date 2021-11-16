package com.example.api.controller;

import com.example.api.dto.SystemDTO;
import com.example.api.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private SystemDTO systemDTO = SystemDTO.getInstance();

    @GetMapping
    public List<Customer> getAllCustomers(){
        return systemDTO.getCustomers();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String dni) throws CustomerInexistException{
        Customer customer = systemDTO.searchCustomer(dni);
        if (customer == null){
            throw new CustomerInexistException();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        if (!systemDTO.createCustomer(customer)){
            return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("User created successfully!");
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        if (!systemDTO.updateCustomer(customer)){
            return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("User updated successfully!");
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String dni){
        if(!systemDTO.deleteCustomer(dni)){
            return new ResponseEntity<>("User does not exist! Please insert a valid dni...", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("User deleted successfully!");
    }


}
