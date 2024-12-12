package com.prueba.ntt.data.application.service;

import org.springframework.stereotype.Service;

import com.prueba.ntt.data.application.ports.in.GetCustomerIn;
import com.prueba.ntt.data.application.ports.out.GetCustomerOut;
import com.prueba.ntt.data.application.ports.out.ValidateTypedocumentOut;
import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.domain.exception.BusinessException;

@Service
public class GetCustomerUseCase implements GetCustomerIn{

	private final GetCustomerOut customerOut;
	private final ValidateTypedocumentOut typedocumentOut;
	
	public GetCustomerUseCase(GetCustomerOut customerOut, ValidateTypedocumentOut typedocumentOut) {
		this.customerOut=customerOut;
		this.typedocumentOut = typedocumentOut;
	}
	
	@Override
	public ClienteDomain getCustomer(String documentType, Long documentNumber) throws BusinessException {
		// TODO Auto-generated method stub
		typedocumentOut.validateTypedocument(documentType);
		return customerOut.getCustomerByDocument(documentType, documentNumber);
	}

}
