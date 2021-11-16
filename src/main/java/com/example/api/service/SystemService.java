package com.example.api.service;

import com.example.api.dto.SystemDTO;
import com.example.api.entity.CollectionArea;
import com.example.api.entity.Customer;
import com.example.api.entity.RealEstateProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter
public class SystemService {
    List<Customer> customers = new ArrayList<>();
    List<CollectionArea> collections = new ArrayList<>();
    List<RealEstateProperty> properties = new ArrayList<>();
    private static SystemService instanceSS;

    public static SystemService getInstance(){
        if (instanceSS == null){
            instanceSS = new SystemService();
        }
        return instanceSS;
    }

}
