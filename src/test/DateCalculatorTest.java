package test;

import java.time.LocalDate;

import org.junit.Test;

import main.model.Checkout;
import main.util.DateCalculator;

public class DateCalculatorTest {

	@Test
	public void testCalculateDueDate() {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		LocalDate dueDate = DateCalculator.calculateDueDate(checkout);
		
		//expect 7/5/20
	}
	
	@Test
	public void testCalculateChargeDaysLadder() {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		int chargeDays = DateCalculator.calculateChargeDays(checkout);
		
	}
	
	@Test
	public void testCalculateChargeDaysChainsaw() {
		Checkout checkout = new Checkout("CHNS", "7/2/15", 5, 25);
		int chargeDays = DateCalculator.calculateChargeDays(checkout);
		
	}
	
	@Test
	public void testCalculateChargeDaysJackhammer() {
		Checkout checkout = new Checkout("JAKD", "9/3/15", 6, 0);
		int chargeDays = DateCalculator.calculateChargeDays(checkout);
		
		
	}
}
