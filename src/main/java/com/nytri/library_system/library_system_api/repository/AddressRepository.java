package com.nytri.library_system.library_system_api.repository;

import com.nytri.library_system.library_system_api.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByRegionContains(String regionName);
    List<Address> findByCountryContains(String countryName);
    List<Address> findByCityContains(String cityName);
    List<Address> findByStreetContains(String streetName);
    List<Address> findByPostCodeContains(Integer postCode);
}