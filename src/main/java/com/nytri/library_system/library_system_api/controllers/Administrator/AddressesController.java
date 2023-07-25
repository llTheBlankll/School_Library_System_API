package com.nytri.library_system.library_system_api.controllers.Administrator;

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

    @PutMapping("/address/add")
    public void addAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.addAddress(address);
        }
    }

    @DeleteMapping("/address/delete")
    public void deleteAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.deleteAddress(address);
            logger.info("Address " + address.getId() + " deleted.");
        }

        logger.info("Address " + address.getId() + " was not deleted.");
    }

    @PostMapping("/address/update")
    public void updateAddress(@RequestBody Address address) {
        if (addressService.process(address)) {
            addressService.updateAddress(address);
            logger.info("Address " + address.getId() + " updated.");
        }

        logger.info("Address " + address.getId() + " was not updated.");
    }
}
