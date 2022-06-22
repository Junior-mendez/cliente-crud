package com.pragma.practica.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.practica.domain.Cliente;
import com.pragma.practica.dto.ClienteDTO;
import com.pragma.practica.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(value = "/create",produces = "application/json")
	public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO cliente){
		return new ResponseEntity<>(clienteService.crear(cliente),HttpStatus.OK);
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ClienteDTO>> listar(){
		return  new ResponseEntity<>(clienteService.listar(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar",produces = "application/json")
	public ResponseEntity<ClienteDTO> update(@RequestParam(name = "id") Long id,@RequestBody ClienteDTO cliente ){
				
		if (clienteService.getId(id)==null) {
			return new ResponseEntity<>(ClienteDTO.builder().build(), HttpStatus.NOT_FOUND);
		}		
		ClienteDTO clienteActualizado = clienteService.actualizar(cliente,id);
		return new ResponseEntity<>(clienteActualizado,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar")
    public ResponseEntity<String> borrar(@RequestParam(name = "id") Long id){
		Cliente cliente =clienteService.getId(id);
		if (cliente==null) {
			return new ResponseEntity<>(id.toString(), HttpStatus.NOT_FOUND);
		}
		clienteService.eliminar(id);
        return new ResponseEntity<>(cliente.getNombre(), HttpStatus.OK);
    }

}
