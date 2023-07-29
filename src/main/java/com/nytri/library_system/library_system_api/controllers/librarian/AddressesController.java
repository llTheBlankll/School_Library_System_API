package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Address;
import com.nytri.library_system.library_system_api.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/addresses")
public class AddressesController {

    private final Logger logger = LoggerFactory.getLogger(AddressesController.class);
    private final AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/add")
    public void addAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.addAddress(address);
        }
    }

    @DeleteMapping("/delete")
    public void deleteAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.deleteAddress(address);
            logger.info(String.format("Address %s deleted", address));
        }

        logger.info(String.format("Address %s was not deleted", address));
    }

    @PostMapping("/update")
    public void updateAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.updateAddress(address);
            logger.info(String.format("Address %s was updated", address));
        }

        logger.info(String.format("Address %s was not updated", address));
    }

    // SEARCH METHODS //
    @GetMapping("/region")
    public List<Address> searchAddressByRegion(@RequestParam String search) {
        return addressService.searchAddressByRegion(search);
    }

    @GetMapping("/street")
    public List<Address> searchAddressByStreet(@RequestParam String search) {
        return addressService.searchAddressByStreet(search);
    }

    @GetMapping("/city")
    public List<Address> searchAddressByCity(@RequestParam String search) {
        return addressService.searchAddressByCity(search);
    }

    @GetMapping("/country")
    public List<Address> searchAddressByCountry(@RequestParam String search) {
        return addressService.searchAddressByCountry(search);
    }

    @GetMapping("/postCode")
    public List<Address> searchAddressByPostCode(@RequestParam Integer search) {
        return addressService.searchAddressByPostCode(search);
    }
}
