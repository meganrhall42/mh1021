package main.util;

import main.model.Checkout;

public class ChargeCalculator {

	/*
	 * Daily rental charge is amount per day, specified by the tool type.
	 */
	public static double calculateDailyRentalCharge(Checkout checkout) {
		
		return 0;
	}
	
	/*
	 * Pre-discount charge is calculated as charge days X daily charge. Resulting total rounded 
	 * half up to cents
	 */
	public static double calculatePreDiscountCharge(Checkout checkout) {
		
		return 0;
	}
	
	/*
	 * Discount amount - calculated from discount % and pre-discount charge. Resulting amount rounded
	 * half up to cents
	 */
	public static double calculateDiscountAmount(Checkout checkout) {
		
		return 0;
	}
	
	/*
	 * Final charge - Calculated as pre-discount charge - discount amount.
	 */
	public static double calculateFinalCharge(Checkout checkout) {
		
		return 0;
	}
}
