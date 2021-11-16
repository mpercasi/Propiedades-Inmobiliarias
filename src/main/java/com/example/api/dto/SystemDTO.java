package com.example.api.dto;

import com.example.api.entity.Customer;
import com.example.api.entity.RealEstateProperty;
import com.example.api.service.SystemService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter
public class SystemDTO {
    private static SystemDTO instanceSystemDTO;
    private SystemService instanceSS = SystemService.getInstance();

    public static SystemDTO getInstance(){
        if (instanceSystemDTO == null){
            instanceSystemDTO = new SystemDTO();
        }
        return instanceSystemDTO;
    }

    // --------------------------------------------
    // Customers ----------------------------------
    // --------------------------------------------

    //Get all customers
    public List<Customer> getCustomers(){
        return instanceSS.getCustomers();
    }

    //Get specific customer
    public Customer searchCustomer(String dni){
        for (Customer c : instanceSS.getCustomers()) {
            if (dni.equals(c.getDni())){
                return c;
            }
        }
        return null;
    }

//    Optional<Unit> optionalUnit = getList().stream().filter(u -> u.getId() == id).findFirst();
//    return optionalUnit.get();

    //Create customer
    public boolean createCustomer(Customer customer){
        if (searchCustomer(customer.getDni()) == null){
            instanceSS.getCustomers().add(customer);
            return true;
        } else{
            return false;
        }
    }

    //Update Customer
    public boolean updateCustomer(Customer customer){
        if (searchCustomer(customer.getDni()) == null){
            return false;
        } else{
            deleteCustomer(customer.getDni());
            createCustomer(customer);
            return true;
        }
    }

    //Delete Customer
    public boolean deleteCustomer(String dni){
        Customer customer = searchCustomer(dni);
        if (customer == null){
            return false;
        }
        instanceSS.getCustomers().remove(customer);
        return true;
    }

    // --------------------------------------------
    // Properties ---------------------------------
    // --------------------------------------------
    //Get all properties
    public List<RealEstateProperty> getProperties(){
        return instanceSS.getProperties();
    }

    //Get single property
    public RealEstateProperty searchProperty(int code){
        for (RealEstateProperty rep : instanceSS.getProperties()) {
            if (rep.getCode() == code){
                return rep;
            }
        }
        return null;
    }

    //Create property
    public boolean createProperty(RealEstateProperty property){
        if (searchProperty(property.getCode()) == null){
            instanceSS.getProperties().add(property);
            return true;
        } else{
            return false;
        }
    }

    //Update property
    public boolean updateProperty(RealEstateProperty property){
        if (searchProperty(property.getCode()) == null){
            return false;
        } else{
            deleteProperty(property.getCode());
            createProperty(property);
            return true;
        }
    }

    //Delete property
    public boolean deleteProperty(int code){
        RealEstateProperty property = searchProperty(code);
        if (property == null){
            return false;
        } else{
            instanceSS.getProperties().remove(property);
            return true;
        }
    }
}
