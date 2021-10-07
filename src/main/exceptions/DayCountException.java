package main.exceptions;

public class DayCountException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DayCountException(String error) {
		super(error);
	}

}
