package main.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Checkout {

	private String toolCode;
	private int rentalDayCount;
	private int discount;
	private LocalDate checkoutDate;
	
	public Checkout() { }

	public Checkout(String toolCode, String checkoutDate, int rentalDayCount, int discount) {
		this.toolCode = toolCode;
		this.rentalDayCount = rentalDayCount;
		this.discount = discount;
		this.checkoutDate = convertStringToDate(checkoutDate);
	}
	
	private LocalDate convertStringToDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/y");
		return LocalDate.parse(stringDate, formatter);
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public int getRentalDayCount() {
		return rentalDayCount;
	}

	public void setRentalDayCount(int rentalDayCount) {
		this.rentalDayCount = rentalDayCount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
}
