package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
