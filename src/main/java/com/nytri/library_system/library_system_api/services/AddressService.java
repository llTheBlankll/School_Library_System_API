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
    public Address getAddressById(Integer addressId) {
        return addressRepository.findById(addressId).orElse(new Address());
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> searchAddressByRegion(String regionName) {
        return addressRepository.findByRegionContains(regionName);
    }

    @Override
    public List<Address> searchAddressByStreet(String streetName) {
        return addressRepository.findByStreetContains(streetName);
    }

    @Override
    public List<Address> searchAddressByCity(String cityName) {
        return addressRepository.findByCityContains(cityName);
    }

    @Override
    public List<Address> searchAddressByCountry(String countryName) {
        return addressRepository.findByCountryContains(countryName);
    }

    @Override
    public List<Address> searchAddressByPostCode(Integer postCode) {
        return addressRepository.findByPostCodeContains(postCode);
    }
}
