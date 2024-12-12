package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.prueba.ntt.data.application.ports.out.ValidateTypedocumentOut;
import com.prueba.ntt.data.domain.exception.BusinessException;
import com.prueba.ntt.data.domain.exception.dto.ResponseError;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.DocumentTypeEntity;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.repository.DocumentTypeRepository;

@Component
public class ValidateDocumentTypeAdapter implements ValidateTypedocumentOut {
	
	private final DocumentTypeRepository documentTypeRepository;
	
	public ValidateDocumentTypeAdapter(DocumentTypeRepository documentTypeRepository) {
		this.documentTypeRepository=documentTypeRepository;
	}

	@Override
	public Boolean validateTypedocument(String documentType) throws BusinessException {
		// TODO Auto-generated method stub
		DocumentTypeEntity documentTypeEntity = null;
		try {
			documentTypeEntity =  documentTypeRepository.findDocumentTypeByName(documentType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(documentTypeEntity == null) {
			ResponseError error = new ResponseError();
			error.setCode(400L);
			error.setLevel("Info");
			error.setDescription("El tipo de documento no es valido");
			throw new BusinessException(HttpStatus.BAD_REQUEST, error);
		}
		
		
		return true;
	}

}
