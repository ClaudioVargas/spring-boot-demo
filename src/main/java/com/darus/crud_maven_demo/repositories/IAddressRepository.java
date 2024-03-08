package com.darus.crud_maven_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darus.crud_maven_demo.entities.AddressEntity;

public interface IAddressRepository extends JpaRepository<AddressEntity, Long>{

}
