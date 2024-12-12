package com.prueba.ntt.data.domain.exception;

import org.springframework.http.HttpStatusCode;

import com.prueba.ntt.data.domain.exception.dto.ResponseError;

public class BusinessException extends Exception {
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1384798736475839203L;
	
	private ResponseError error;
	private HttpStatusCode code;
	
	public BusinessException(HttpStatusCode code, ResponseError error) {
		this.code=code;
		this.error=error;
	}

	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public HttpStatusCode getCode() {
		return code;
	}

	public void setCode(HttpStatusCode code) {
		this.code = code;
	}

}
