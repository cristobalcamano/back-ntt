package com.prueba.ntt.data.infrastructure.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.ntt.data.application.service.GetCustomerUseCase;
import com.prueba.ntt.data.domain.ClienteDomain;
import com.prueba.ntt.data.domain.exception.BusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${path-customer}")
@Tag(name = "Api Customer", description = "api encargada de la gestion para la entidad de customer")
public class CustomerController {

	private final GetCustomerUseCase customerUseCase;

	public CustomerController(GetCustomerUseCase customerUseCase) {
		this.customerUseCase = customerUseCase;
	}

	@Operation(summary = "Consultar un cliente", description = "Consultar un cliente por su tipo y numero de documento")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class), examples = @ExampleObject(name = "Resultado exitoso", value = "{\"primerNombre\": \"\", \"segundoNombre\": \"\", \"primerApellido\": \"\", \"segundoApellido\": \"\",\n" +
					"\"telefono\": \"\", \"direccion\": \"\", \"documento\": \"\", \"tipoDocumento\": \"\",\"ciudadResidencia\": \"\"}"))),
			@ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class), examples = @ExampleObject(name = "Resultado insatisfecho ",
					value = "{\"code\": 404,\"level\": \"Info\",\"description\": \"Usuario no se encontro en la base de datos\"}"))),
			@ApiResponse(responseCode = "400", description = "Error en la petición", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class), examples = @ExampleObject(name = "Resultado insatisfecho ",
					value = "{ \"code\": 400, \"level\": \"Info\", \"description\": \"El tipo de documento no es valido\"}"))),
			@ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class), examples = @ExampleObject(name = "Error del servidor", value = "Error en el servidor, Por favor intentar mas tarde"))) })
	@GetMapping(path = "{tipe-doc}/{num-doc}")
	public ResponseEntity<?> getCustomer(@PathVariable("tipe-doc") String typeDoc,
			@PathVariable("num-doc") Long numDoc) {
		try {
			ClienteDomain customerDomain = customerUseCase.getCustomer(typeDoc, numDoc);
			return new ResponseEntity(customerDomain, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity(e.getError(), e.getCode());
		}
	}

}
