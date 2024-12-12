package com.prueba.ntt.data.application.ports.out;

import com.prueba.ntt.data.domain.exception.BusinessException;

public interface ValidateTypedocumentOut {
	
	public Boolean validateTypedocument(String documentType) throws BusinessException;

}
