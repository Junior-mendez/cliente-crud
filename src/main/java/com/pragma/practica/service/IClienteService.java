package com.pragma.practica.service;

import java.util.List;

import com.pragma.practica.domain.Cliente;
import com.pragma.practica.dto.ClienteDTO;

public interface IClienteService {
	
	ClienteDTO crear(ClienteDTO cliente);
	
	List<ClienteDTO> listar();
	
	ClienteDTO actualizar(ClienteDTO cliente, Long id);
	
	Cliente getId(Long id);
	
	void eliminar(Long id);

}
