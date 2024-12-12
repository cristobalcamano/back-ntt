package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2;

import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.CustomerEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.prueba.ntt.data.application.ports.out.GetCustomerOut;
import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.domain.exception.BusinessException;
import com.prueba.ntt.data.domain.exception.dto.ResponseError;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.CustomerEntity;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.repository.CustomerRepository;

@Component
public class GetCustomerAdapter implements GetCustomerOut {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	public GetCustomerAdapter(CustomerRepository customerRepository,
							  CustomerEntityMapper customerEntityMapper) {
		this.customerRepository = customerRepository;
		this.customerEntityMapper=customerEntityMapper;
	}

	@Override
	public ClienteDomain getCustomerByDocument(String documentType, Long documentNumber) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerEntity customer = null;
		try {
			customer = customerRepository.findCustomerByDocTypeAndDocNumber(documentType, documentNumber);
		} catch (Exception e) {
			ResponseError error = new ResponseError();
			error.setCode(500L);
			error.setLevel("Error");
			error.setDescription("Volver a intentar por favor. si persiste el error contactar con el administrador.");
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, error);
		}

		if (customer == null) {
			ResponseError error = new ResponseError();
			error.setCode(404L);
			error.setLevel("Info");
			error.setDescription("Usuario no se encontro en la base de datos");
			throw new BusinessException(HttpStatus.NOT_FOUND, error);
		}
		return customerEntityMapper.convertEntitytoDomain(customer);

	}

}
