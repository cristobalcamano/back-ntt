package com.prueba.ntt.data.application.ports.in;

import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.domain.exception.BusinessException;

public interface GetCustomerIn {

	public ClienteDomain getCustomer(String documentType, Long documentNumber) throws BusinessException;
	
}
