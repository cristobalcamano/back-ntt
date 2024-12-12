package com.prueba.ntt.data.infrastructure.adapter.out.databaseH2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class CustomerEntity {
	
	@Id
    @GeneratedValue
	private Long id;
	@Column(name = "nombre_1")
	private String firstName;
	@Column(name = "nombre_2")
	private String secondName;
	@Column(name = "apellido_1")
	private String firstSurname;
	@Column(name = "apellido_2")
	private String secondSurname;
	@Column(name = "telefono")
	private String phone;
	@Column(name = "direccion")
	private String address;
	@Column(name = "ciudad")
	private String city;
	@Column(name = "documento")
	private String document;
	@ManyToOne
    @JoinColumn(name = "tipo_documento_fk", nullable = false)
	private DocumentTypeEntity documentType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	public String getSecondSurname() {
		return secondSurname;
	}
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public DocumentTypeEntity getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentTypeEntity documentType) {
		this.documentType = documentType;
	}

}
