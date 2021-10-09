package main.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ChargeCalculator {
	
	/*
	 * Pre-discount charge is calculated as charge days X daily charge. Resulting total rounded 
	 * half up to cents
	 */
	public static double calculatePreDiscountCharge(int chargeDays, double dailyCharge) {
		
		return (chargeDays * dailyCharge);
	}
	
	/*
	 * Discount amount - calculated from discount % and pre-discount charge. Resulting amount rounded
	 * half up to cents
	 */
	public static double calculateDiscountAmount(int discount, double preDiscountCharge) {
		BigDecimal convertedDiscount = BigDecimal.valueOf(discount);
		BigDecimal convertedPreDiscountCharge = BigDecimal.valueOf(preDiscountCharge);
		
		BigDecimal discountAsPercent = convertedDiscount.divide(BigDecimal.valueOf(100));
		BigDecimal unrounded = discountAsPercent.multiply(convertedPreDiscountCharge);
		BigDecimal rounded = unrounded.setScale(2, RoundingMode.HALF_UP);
		
		return rounded.doubleValue();
	}
	
	/*
	 * Final charge - Calculated as pre-discount charge - discount amount.
	 */
	public static double calculateFinalCharge(double preDiscountCharge, double discountAmount) {
		
		return (preDiscountCharge - discountAmount);
	}
}
