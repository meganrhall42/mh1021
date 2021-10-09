package test;

import org.junit.Assert;
import org.junit.Test;

import main.model.Checkout;
import main.util.ChargeCalculator;

public class ChargeCalculatorTest {
	
	@Test
	public void testCalculatePreDiscountCharge () {
		int chargeDays = 3;
		double dailyCharge = 2.99;
		double preDiscountAmount = ChargeCalculator.calculatePreDiscountCharge(chargeDays, dailyCharge);
		
		Assert.assertEquals(8.97, preDiscountAmount, 0);
	}
	
	@Test
	public void testCalculateDiscountAmount () {
		int discount = 10;
		double preDiscountCharge = 8.97;
		double discountAmount = ChargeCalculator.calculateDiscountAmount(discount, preDiscountCharge);
		
		Assert.assertEquals(0.9, discountAmount, 0);
	}
	
	@Test
	public void testCalculateDiscountAmountNoDiscount () {
		int discount = 0;
		double preDiscountCharge = 8.97;
		double discountAmount = ChargeCalculator.calculateDiscountAmount(discount, preDiscountCharge);
		
		Assert.assertEquals(0, discountAmount, 0);
	}
	
	@Test
	public void testCalculateFinalCharge () {
		double preDiscountCharge = 8.97;
		double discountAmount = .9;
		double finalCharge = ChargeCalculator.calculateFinalCharge(preDiscountCharge, discountAmount);
		
		Assert.assertEquals(8.07, finalCharge, 0);
	}
	
	@Test
	public void testCalculateFinalChargeNoDiscount () {
		double preDiscountCharge = 8.97;
		double discountAmount = 0.0;
		double finalCharge = ChargeCalculator.calculateFinalCharge(preDiscountCharge, discountAmount);
		
		Assert.assertEquals(8.97, finalCharge, 0);
	}
	

}
