package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @Column(name = "region", length = 48)
    private String region;

    @Column(name = "street", length = 48)
    private String street;

    @Column(name = "city", length = 48)
    private String city;

    @Column(name = "postcode")
    private Integer postCode;

    @Column(name = "country", length = 48)
    private String country;

    @OneToOne(mappedBy = "studentAddress", cascade = CascadeType.MERGE)
    private Student studentAddress;

    @OneToOne(mappedBy = "employeeAddress", cascade = CascadeType.MERGE)
    private Employee employeeAddress;

    public void setEmployeeAddress(Employee employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setStudentAddress(Student studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public boolean isValid() {
        if (this.id <= 0) {
            return false;
        }

        if (this.getRegion().isEmpty()) {
            return false;
        }

        return !this.getStreet().isEmpty();
    }
}