--Creación de la tabla en base de datos del tipo de documento
CREATE TABLE tipo_documento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);
INSERT INTO tipo_documento (id,nombre,descripcion) values (1, 'C', 'Cédula de ciudadanía');
INSERT INTO tipo_documento (id,nombre,descripcion) values (2, 'P', 'Pasaporte');

--Creación de la tabla en de datos del cliente
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_1 VARCHAR(16),
    nombre_2 VARCHAR(255),
    apellido_1 VARCHAR(255),
    apellido_2 VARCHAR(255),
    telefono VARCHAR(255),
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    documento VARCHAR(255),
    tipo_documento_fk INT,
    FOREIGN KEY (tipo_documento_fk) REFERENCES tipo_documento(id)
);

INSERT INTO cliente (id, nombre_1, nombre_2, apellido_1, apellido_2, telefono, direccion, ciudad, documento, tipo_documento_fk ) 
    values (1, 'Carlos', 'Andres','Guerra','Perdomo','666-66-66','Calle 1 #1 - 1','cali','23445322',1);
