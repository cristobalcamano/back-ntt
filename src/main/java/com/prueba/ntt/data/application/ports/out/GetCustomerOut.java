package com.prueba.ntt.data.application.ports.out;

import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.domain.exception.BusinessException;

public interface GetCustomerOut {
	
	public ClienteDomain getCustomerByDocument(String documentType, Long documentNumber) throws BusinessException;

}
