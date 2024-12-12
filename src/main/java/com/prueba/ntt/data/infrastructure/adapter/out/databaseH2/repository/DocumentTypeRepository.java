package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity.DocumentTypeEntity;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, Long> {

	@Query(value = "Select t.* from tipo_documento t "
			+ "where t.nombre = :tipo",
			nativeQuery = true)
	public DocumentTypeEntity findDocumentTypeByName(@Param("tipo") String tipoDoc);
	
	
}
