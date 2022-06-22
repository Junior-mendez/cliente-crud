package com.pragma.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pragma.practica.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
