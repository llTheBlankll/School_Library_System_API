package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Address;
import com.nytri.library_system.library_system_api.repository.AddressRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/manager/addresses")
@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController( AddressRepository addressRepository ) {
       this.addressRepository = addressRepository;
    }

    @GetMapping("/all")
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }


}
