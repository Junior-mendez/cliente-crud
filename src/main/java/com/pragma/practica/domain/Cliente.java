package com.pragma.practica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1502180613839513307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "ciudad_nacimiento")
	private String ciudadNacimiento;

}
