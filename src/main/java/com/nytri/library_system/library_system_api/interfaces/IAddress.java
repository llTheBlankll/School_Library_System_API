package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Address;

import java.util.List;

public interface IAddress {
    void addAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(Address address);
    List<Address> searchAddressByRegion(String regionName);
    List<Address> searchAddressByStreet(String streetName);
    List<Address> searchAddressByCity(String cityName);
    List<Address> searchAddressByCountry(String countryName);
    List<Address> searchAddressByPostCode(Integer postCode);
    Address getAddressById(Integer address_id);
    List<Address> getAllAddresses();
}
