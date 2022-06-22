package com.pragma.practica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	@JsonProperty("name")
	private String nombre;
	@JsonProperty("lastname")
	private String apellido;
	@JsonProperty("document_type")
	private String tipoDocumento;
	@JsonProperty("document")
	private String documento;
	@JsonProperty("age")
	private Integer edad;
	@JsonProperty("city_birth")
	private String ciudadNacimiento;
	
	public ClienteDTOBuilder mutate() {
		return ClienteDTO.builder().nombre(nombre);
	}

}
