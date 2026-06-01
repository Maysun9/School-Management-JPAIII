package com.example.schoolmanagmentjpa.Repository;

import com.example.schoolmanagmentjpa.Model.Address;
import com.example.schoolmanagmentjpa.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}