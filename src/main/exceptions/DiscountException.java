package main.exceptions;

public class DiscountException extends Exception {

	private static final long serialVersionUID = 1L;

	public DiscountException(String error) {
		super(error);
	}
}
