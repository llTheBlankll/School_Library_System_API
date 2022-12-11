package com.nytri.library_system.library_system_api.controllers;

import com.nytri.library_system.library_system_api.entities.Address;
import com.nytri.library_system.library_system_api.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/administrator/addresses")
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

    @GetMapping("/find/region/{region}")
    public List<Address> findAddressByRegion(@RequestParam("region") String region) {
        return this.addressRepository.findByRegionContains(region);
    }

    @PutMapping("/add")
    public void addAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @DeleteMapping("/delete")
    public void deleteAddress(@RequestBody Address address) {
        addressRepository.delete(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddressById(@RequestParam int addressId) {
        addressRepository.deleteById(addressId);
    }

    @PostMapping("/update")
    public void updateAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }
}
