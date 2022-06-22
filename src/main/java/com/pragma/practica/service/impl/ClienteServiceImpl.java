package com.pragma.practica.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pragma.practica.domain.Cliente;
import com.pragma.practica.dto.ClienteDTO;
import com.pragma.practica.repository.ClienteRepository;
import com.pragma.practica.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteDTO crear(ClienteDTO cliente) {
		Cliente clienteNew = Cliente.builder().nombre(cliente.getNombre())
				.apellido(cliente.getApellido())
				.tipoDocumento(cliente.getTipoDocumento())
				.documento(cliente.getDocumento())
				.edad(cliente.getEdad())
				.ciudadNacimiento(cliente.getCiudadNacimiento()).build();

		Cliente clienteRegistrado = clienteRepository.save(clienteNew);
		
		return ClienteDTO.builder()
				.nombre(clienteRegistrado.getNombre())
				.apellido(clienteRegistrado.getApellido())
				.edad(clienteRegistrado.getEdad())
				.tipoDocumento(clienteRegistrado.getTipoDocumento())
				.documento(clienteRegistrado.getDocumento())
				.ciudadNacimiento(clienteRegistrado.getCiudadNacimiento())
				.build();
	}

	@Override
	public List<ClienteDTO> listar() {
		List<ClienteDTO> clientes = new ArrayList<>();
		
		List<Cliente> clientesObtenidos=StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
	    .collect(Collectors.toList());
		
		
		for (Cliente clienteRegistrado : clientesObtenidos) {
			clientes.add(ClienteDTO.builder()
				.nombre(clienteRegistrado.getNombre())
				.apellido(clienteRegistrado.getApellido())
				.edad(clienteRegistrado.getEdad())
				.tipoDocumento(clienteRegistrado.getTipoDocumento())
				.documento(clienteRegistrado.getDocumento())
				.ciudadNacimiento(clienteRegistrado.getCiudadNacimiento())
				.build());
			
		}
		
		
		return clientes;
	}

	@Override
	public ClienteDTO actualizar(ClienteDTO cliente, Long id) {
		Cliente clienteNew = Cliente.builder()
				.id(id).nombre(cliente.getNombre())
				.apellido(cliente.getApellido())
				.tipoDocumento(cliente.getTipoDocumento())
				.documento(cliente.getDocumento())
				.edad(cliente.getEdad())
				.ciudadNacimiento(cliente.getCiudadNacimiento()).build();


		Cliente	clienteActualizado = clienteRepository.save(clienteNew);
		
		return ClienteDTO.builder()
				.nombre(clienteActualizado.getNombre())
				.apellido(clienteActualizado.getApellido())
				.edad(clienteActualizado.getEdad())
				.tipoDocumento(clienteActualizado.getTipoDocumento())
				.documento(clienteActualizado.getDocumento())
				.ciudadNacimiento(clienteActualizado.getCiudadNacimiento())
				.build();
	}

	@Override
	public Cliente getId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
//		if (cliente.isPresent()) {
//			return cliente.get();
//		}
//		return null;
		Cliente cliente1 = clienteRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el cliente"));
		return cliente1;
	}

	@Override
	public void eliminar( Long id) {
		clienteRepository.deleteById(id);
	}

}
