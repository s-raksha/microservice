package com.order.exception;

public class OutOfStockException extends RuntimeException {

	public OutOfStockException(String Message) {
		super(Message);
	}

}
