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

    @Column(name = "postcode")
    private Integer postcode;

    @OneToOne(mappedBy = "studentAddress", cascade = CascadeType.MERGE)
    private Student student_address;

    @OneToOne(mappedBy = "employeeAddress", cascade = CascadeType.MERGE)
    private Employee employee_address;

    public Address(Integer id, String region, String street, Integer postcode, Student student_address, Employee employee_address) {
        this.id = id;
        this.region = region;
        this.street = street;
        this.postcode = postcode;
        this.student_address = student_address;
        this.employee_address = employee_address;
    }

    public void setEmployee_address(Employee employee_address) {
        this.employee_address = employee_address;
    }

    public void setStudent_address(Student student_address) {
        this.student_address = student_address;
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public boolean isValid() {
        if (this.id <= 0) {
            return false;
        }

        if (this.student_address == null && this.employee_address == null) {
            return false;
        }

        if (this.region.isEmpty()) {
            return false;
        }

        return !this.street.isEmpty();
    }
}