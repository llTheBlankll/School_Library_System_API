package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Address;

import java.util.List;

public interface IAddress {
    void addAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(Address address);
    Address getAddressById(Integer address_id);
    List<Address> getAllAddresses();
}
