package test;

import org.junit.Test;

import main.model.Checkout;
import main.util.ChargeCalculator;

public class ChargeCalculatorTest {
	
	@Test
	public void testCalculateDailyRentalChargeLadder() {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		double dailyRentalCharge = ChargeCalculator.calculateDailyRentalCharge(checkout);
	}
	
	@Test
	public void testCalculateDailyRentalChargeChainsaw() {
		Checkout checkout = new Checkout("CHNS", "7/2/15", 5, 25);
		double dailyRentalCharge = ChargeCalculator.calculateDailyRentalCharge(checkout);
	}
	
	@Test
	public void testCalculateDailyRentalChargeJackhammer() {
		Checkout checkout = new Checkout("JAKD", "9/3/15", 6, 0);
		double dailyRentalCharge = ChargeCalculator.calculateDailyRentalCharge(checkout);
	}
	
	@Test
	public void testCalculatePreDiscountCharge () {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		double preDiscountAmount = ChargeCalculator.calculatePreDiscountCharge(checkout);
	}
	
	@Test
	public void testCalculateDiscountAmount () {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		double discountAmount = ChargeCalculator.calculateDiscountAmount(checkout);
	}
	
	@Test
	public void testCalculateDiscountAmountNoDiscount () {
		Checkout checkout = new Checkout("JAKD", "9/3/15", 6, 0);
		double discountAmount = ChargeCalculator.calculateDiscountAmount(checkout);
	}
	
	@Test
	public void testCalculateFinalCharge () {
		Checkout checkout = new Checkout("LADW", "7/2/20", 3, 10);
		double finalCharge = ChargeCalculator.calculateFinalCharge(checkout);
	}
	

}
