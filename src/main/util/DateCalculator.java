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
		int chargeDayCount = 0;
		
		//Start count at day after checkout
		LocalDate testDate = checkoutDate.plusDays(1);

		//Check every day until we reach the due date
		while(!testDate.isAfter(dueDate)) {
			if(checkIfHoliday(testDate)) {
				//add a charge day if tool has a holiday charge and date is a holiday
				if(type.isHolidayCharge()) {
					chargeDayCount ++;
				}
			} else {
				boolean isWeekend = checkIfWeekend(testDate);
				if(type.isWeekdayCharge() && !isWeekend) {
					//add a charge day if tool has a weekday charge and date is a weekday
					chargeDayCount ++;
				} else if(type.isWeekendCharge() && isWeekend) {
					//add a charge day if tool has a weekend charge and date is a weekend
					chargeDayCount ++;
				} 
			}
				
			testDate = testDate.plusDays(1);
		}

		return chargeDayCount;
	}
	
	public static boolean checkIfWeekend(LocalDate date) {
		
		return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
	}
	
	public static boolean checkIfHoliday(LocalDate date) {	
		int dayOfTheMonth = date.getDayOfMonth();
		LocalDate julyFourth = LocalDate.of(date.getYear(), 7, 4);
		
		if(date.equals(julyFourth) && !checkIfWeekend(date)) {
			// Independence Day, July 4th - If falls on weekend, it is observed on the closest weekday
			return true;
		} else if(date.getMonth() == Month.JULY && dayOfTheMonth == 3 && julyFourth.getDayOfWeek() == DayOfWeek.SATURDAY) {
			//If Independence Day falls on Sat, observed on the Friday before
			return true;
		} else if(date.getMonth() == Month.JULY && dayOfTheMonth == 5 && julyFourth.getDayOfWeek() == DayOfWeek.SUNDAY) {
			//If Independence Day falls on Sun, observed on the Monday after
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
