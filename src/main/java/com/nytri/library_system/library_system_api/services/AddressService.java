package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Address;
import com.nytri.library_system.library_system_api.interfaces.IAddress;
import com.nytri.library_system.library_system_api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AddressService implements IAddress {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        Assert.notNull(addressRepository, "AddressRepository must not be null");
        this.addressRepository = addressRepository;
    }

     public boolean process(Address address) {
        // Returns true if it is Empty, false otherwise.
        return !address.getStreet().isEmpty() && !address.getRegion().isEmpty();
    }

    @Override
    public void addAddress(Address address) {
        if (this.process(address)) {
            addressRepository.save(address);
        }
    }

    @Override
    public void updateAddress(Address address) {
        if (this.process(address)) {
            addressRepository.save(address);
        }
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address getAddressById(Integer address_id) {
        return addressRepository.findById(address_id).orElse(new Address());
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
