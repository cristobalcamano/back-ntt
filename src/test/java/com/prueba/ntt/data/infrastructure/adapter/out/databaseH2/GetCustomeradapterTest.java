package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.CustomerEntity;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.CustomerEntityMapper;
import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class GetCustomeradapterTest {
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	CustomerEntityMapper customerEntityMapper;
	
	@InjectMocks
	GetCustomerAdapter adapter;
	
	
	
	@Test
	public void getCustomerByDocumentTest() {
		
		adapter = new GetCustomerAdapter(customerRepository, customerEntityMapper);
		
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1L);
		when(customerRepository.findCustomerByDocTypeAndDocNumber(any(),any())).thenReturn(customer);
		
		ClienteDomain cliente = new ClienteDomain();
		cliente.setDocumento("123");
		when(customerEntityMapper.convertEntitytoDomain(customer)).thenReturn(cliente);
		
		try {
			ClienteDomain respnose = adapter.getCustomerByDocument("CC", 1L);
			assertTrue(respnose.getDocumento().equalsIgnoreCase("123"));
		} catch (Exception e) {
			assertTrue(false);
		}
		
		
	}

}
