package main.service;

import java.time.LocalDate;

import main.exceptions.DayCountException;
import main.exceptions.DiscountException;
import main.model.AvailableTool;
import main.model.Checkout;
import main.model.RentalAgreement;
import main.util.ChargeCalculator;
import main.util.DateCalculator;

public class CheckoutService {

	public static RentalAgreement processCheckout(Checkout checkout) { //throws DiscountException, DayCountException
		//TODO fully use later
		//validateCheckout(checkout);
		RentalAgreement agreement = generateRentalAgreement(checkout);
		
		return agreement;
	}
	
	private static RentalAgreement generateRentalAgreement(Checkout checkout) {
		
		AvailableTool selectedtool = AvailableTool.valueOf(checkout.getToolCode());
		LocalDate dueDate = DateCalculator.calculateDueDate(checkout);
		double dailyRentalCharge = ChargeCalculator.calculateDailyRentalCharge(checkout);
		int chargeDays = DateCalculator.calculateChargeDays(checkout);
		double preDiscountCharge = ChargeCalculator.calculatePreDiscountCharge(checkout);
		double discountAmount = ChargeCalculator.calculateDiscountAmount(checkout);
		double finalCharge = ChargeCalculator.calculateFinalCharge(checkout);
		
		RentalAgreement agreement = new RentalAgreement(selectedtool, checkout, dueDate, dailyRentalCharge,
				chargeDays, preDiscountCharge, discountAmount, finalCharge);
		
		return agreement;
	}
	
	private static void validateCheckout(Checkout checkout) throws DayCountException, DiscountException {
		if(checkout.getRentalDayCount() < 1) {
			throw new DayCountException("Rental Day Count must be great than 1.");
		}
		
		if(checkout.getDiscount() > 100 || checkout.getDiscount() < 0) {
			throw new DiscountException("Discount must be in the 0-100 range.");
		}
	}
	
}
