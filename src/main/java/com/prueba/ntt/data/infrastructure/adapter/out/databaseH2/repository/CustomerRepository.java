package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	@Query(value = "Select c.* from Cliente c inner join tipo_documento tp on "
			+ "c.tipo_documento_fk = tp.id "
			+ "where tp.nombre = :tipo and c.documento = :doc",
			nativeQuery = true)
	public CustomerEntity findCustomerByDocTypeAndDocNumber(@Param("tipo") String tipoDoc, @Param("doc") Long doc);

}
