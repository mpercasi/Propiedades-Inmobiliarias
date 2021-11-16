package com.example.api.controller;

import com.example.api.dto.SystemDTO;
import com.example.api.entity.Customer;
import com.example.api.entity.RealEstateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class RealEstatePropertyController {

    @Autowired
    private SystemDTO systemDTO = SystemDTO.getInstance();

    @GetMapping
    public List<RealEstateProperty> getAllCustomers(){
        return systemDTO.getProperties();
    }

    @GetMapping("/{code}")
    public ResponseEntity<RealEstateProperty> getCustomer(@PathVariable int code) throws RealEstatePropertyNonExist{
        RealEstateProperty property = systemDTO.searchProperty(code);
        if (property == null){
            throw new RealEstatePropertyNonExist();
        }
        return ResponseEntity.ok(property);
    }

    @PostMapping
    public ResponseEntity<String> createProperty(@RequestBody RealEstateProperty property){
        if (!systemDTO.createProperty(property)){
            return new ResponseEntity<>("Property already exist!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Property created successfully!");
    }

    @PutMapping
    public ResponseEntity<String> updateProperty(@RequestBody RealEstateProperty property){
        if (!systemDTO.updateProperty(property)){
            return new ResponseEntity<>("Property does not exist!", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Property updated successfully!");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteProperty(@PathVariable int code){
        if (!systemDTO.deleteProperty(code)){
            return new ResponseEntity<>("Property does not exist! Please insert a valid property code", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Property deleted successfully");
    }

}
