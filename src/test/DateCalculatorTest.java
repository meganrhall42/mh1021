package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import main.model.Checkout;
import main.model.ToolType;
import main.util.DateCalculator;

public class DateCalculatorTest {

	@Test
	public void testCalculateDueDate() {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		LocalDate dueDate = DateCalculator.calculateDueDate(checkout);
		
		LocalDate expectedDate = LocalDate.of(2020, 7, 5);
		assertEquals(expectedDate, dueDate);
	}
	
	@Test
	public void testIsWeekend() {
		LocalDate date = LocalDate.of(2020, 7, 5);
		boolean isWeekend = DateCalculator.checkIfWeekend(date);
		
		assertTrue(isWeekend);
	}
	
	@Test
	public void testIsWeekDay() {
		LocalDate date = LocalDate.of(2020, 7, 2);
		boolean isWeekend = DateCalculator.checkIfWeekend(date);
		
		assertFalse(isWeekend);
	}
	
	@Test
	public void testIsIndependenceDayWeekday() {
		LocalDate date = LocalDate.of(2019, 7, 4);
		boolean isHoliday = DateCalculator.checkIfHoliday(date);
		
		assertTrue(isHoliday);
	}
	
	@Test
	public void testIsIndependenceDayWeekend() {
		LocalDate date = LocalDate.of(2020, 7, 4);
		boolean isHoliday = DateCalculator.checkIfHoliday(date);
		
		assertFalse(isHoliday);
	}
	
	@Test
	public void testIsObservedIndependenceDay() {
		LocalDate date = LocalDate.of(2020, 7, 3);
		boolean isHoliday = DateCalculator.checkIfHoliday(date);
		
		assertTrue(isHoliday);
	}
	
	@Test
	public void testIsLaborDay() {
		LocalDate date = LocalDate.of(2020, 9, 7);
		boolean isHoliday = DateCalculator.checkIfHoliday(date);
		
		assertTrue(isHoliday);
	}
	
	@Test
	public void testIsNotHoliday() {
		LocalDate date = LocalDate.of(2020, 9, 2);
		boolean isHoliday = DateCalculator.checkIfHoliday(date);
		
		assertFalse(isHoliday);
	}
	
	@Test
	public void testCalculateChargeDaysLadder() {
		LocalDate checkoutDate = LocalDate.of(2020, 7, 2);
		LocalDate dueDate = LocalDate.of(2020, 7, 5);
		
		int chargeDays = DateCalculator.calculateChargeDays(checkoutDate, dueDate, ToolType.LADDER);
		
		assertEquals(2, chargeDays);
	}
	
	@Test
	public void testCalculateChargeDaysChainsaw() {
		LocalDate checkoutDate = LocalDate.of(2015, 7, 2);
		LocalDate dueDate = LocalDate.of(2015, 7, 7);
		
		int chargeDays = DateCalculator.calculateChargeDays(checkoutDate, dueDate, ToolType.CHAINSAW);
		
		assertEquals(3, chargeDays);
	}
	
	@Test
	public void testCalculateChargeDaysJackhammer() {
		LocalDate checkoutDate = LocalDate.of(2015, 9, 2);
		LocalDate dueDate = LocalDate.of(2015, 9, 9);
		
		int chargeDays = DateCalculator.calculateChargeDays(checkoutDate, dueDate, ToolType.JACKHAMMER);
		
		assertEquals(4, chargeDays);
	}
}
