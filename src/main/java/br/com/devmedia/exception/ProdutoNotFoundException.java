package br.com.devmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends RuntimeException {
	private String produtoName;
	private String fieldName;
	private Object fieldValue;

	public ProdutoNotFoundException(String produtoName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", produtoName, fieldName, fieldValue));
		this.produtoName = produtoName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getProdutoName() {
		return produtoName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}