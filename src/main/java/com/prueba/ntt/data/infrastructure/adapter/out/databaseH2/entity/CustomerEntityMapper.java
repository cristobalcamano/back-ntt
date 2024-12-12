package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity;

import org.springframework.stereotype.Component;

import com.prueba.ntt.data.domain.ClienteDomain;

@Component
public class CustomerEntityMapper {
	
	public ClienteDomain convertEntitytoDomain(CustomerEntity entity) {
		ClienteDomain domain = new ClienteDomain();
		domain.setCiudadResidencia(entity.getCity());
		domain.setDireccion(entity.getAddress());
		domain.setDocumento(entity.getDocument());
		domain.setPrimerNombre(entity.getFirstName());
		domain.setPrimerApellido(entity.getFirstSurname());
		domain.setSegundoNombre(entity.getSecondName());
		domain.setSegundoApellido(entity.getSecondSurname());
		domain.setTelefono(entity.getPhone());
		domain.setTipoDocumento(entity.getDocumentType().getDescription());
		return domain;
	}

}
