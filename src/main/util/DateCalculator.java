package main.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import main.model.Checkout;
import main.model.ToolType;

public class DateCalculator {

	/*
	 * Due date is calculated from checkout date and rental days
	 */
	public static LocalDate calculateDueDate(Checkout checkout) {
		
		return checkout.getCheckoutDate().plusDays(checkout.getRentalDayCount());
	}
	
	/*
	 * Charge days are the count of chargeable days, from day after checkout through and including due date,
		excluding “no charge” days as specified by the tool type
	 */
	public static int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, ToolType type) {

		
		return 0;
	}
	
	public static boolean checkIfWeekend(LocalDate date) {
		
		return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
	}
	
	public static boolean checkIfHoliday(LocalDate date) {	
		
		if(date.getMonth() == Month.JULY && date.getDayOfMonth() == 4) {
			// Independence Day, July 4th
			return true;
		} else if(date.getMonth() == Month.SEPTEMBER) {
			//Labor Day - First Monday in September
			LocalDate firstMonday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
			if(date.equals(firstMonday)) {
				return true;
			}
		}
		return false;
	}
}
