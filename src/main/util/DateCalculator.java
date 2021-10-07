package main.util;

import java.time.LocalDate;

import main.model.Checkout;

public class DateCalculator {

	/*
	 * Due date is calculated from checkout date and rental days
	 */
	public static LocalDate calculateDueDate(Checkout checkout) {

		return null;
	}
	
	/*
	 * Charge days are the count of chargeable days, from day after checkout through and including due date,
		excluding “no charge” days as specified by the tool type
	 */
	public static int calculateChargeDays(Checkout checkout) {
		
		return 0;
	}
}
