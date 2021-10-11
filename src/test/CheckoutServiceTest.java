package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;

import main.exceptions.DayCountException;
import main.exceptions.DiscountException;
import main.model.AvailableTool;
import main.model.Checkout;
import main.model.RentalAgreement;
import main.service.CheckoutService;

public class CheckoutServiceTest {
	
	@Test(expected = DiscountException.class)
	public void testOne() throws DiscountException, DayCountException {
		Checkout checkoutOne = new Checkout("JAKR", "9/3/15", 5, 101);
		CheckoutService.processCheckout(checkoutOne);
	}
	
	@Test
	public void testTwo() throws DiscountException, DayCountException {
		Checkout checkoutTwo = new Checkout("LADW", "7/2/20", 3, 10);
		RentalAgreement generatedAgreement = CheckoutService.processCheckout(checkoutTwo);
		assertNotNull(generatedAgreement);
		
		assertEquals(AvailableTool.LADW, generatedAgreement.getTool());
		assertEquals(checkoutTwo, generatedAgreement.getCheckout());
		assertEquals(LocalDate.of(2020, 7, 5), generatedAgreement.getDueDate());
		assertEquals(1.99, generatedAgreement.getDailyRentalCharge(), 0);
		assertEquals(2, generatedAgreement.getChargeDays());
		assertEquals(3.98, generatedAgreement.getPrediscountCharge(), 0);
		assertEquals(.4, generatedAgreement.getDiscountAmount(), 0);
		assertEquals(3.58, generatedAgreement.getFinalCharge(), 0);
		
	}
	
	@Test
	public void testThree() throws DiscountException, DayCountException {
		Checkout checkoutThree = new Checkout("CHNS", "7/2/15", 5, 25);
		RentalAgreement generatedAgreement = CheckoutService.processCheckout(checkoutThree);
		assertNotNull(generatedAgreement);
		
		assertEquals(AvailableTool.CHNS, generatedAgreement.getTool());
		assertEquals(checkoutThree, generatedAgreement.getCheckout());
		assertEquals(LocalDate.of(2015, 7, 7), generatedAgreement.getDueDate());
		assertEquals(1.49, generatedAgreement.getDailyRentalCharge(), 0);
		assertEquals(3, generatedAgreement.getChargeDays());
		assertEquals(4.47, generatedAgreement.getPrediscountCharge(), 0);
		assertEquals(1.12, generatedAgreement.getDiscountAmount(), 0);
		assertEquals(3.35, generatedAgreement.getFinalCharge(), 0);
	}
	
	@Test
	public void testFour() throws DiscountException, DayCountException {
		Checkout checkoutFour = new Checkout("JAKD", "9/3/15", 6, 0);
		RentalAgreement generatedAgreement = CheckoutService.processCheckout(checkoutFour);
		assertNotNull(generatedAgreement);
		
		assertEquals(AvailableTool.JAKD, generatedAgreement.getTool());
		assertEquals(checkoutFour, generatedAgreement.getCheckout());
		assertEquals(LocalDate.of(2015, 9, 9), generatedAgreement.getDueDate());
		assertEquals(2.99, generatedAgreement.getDailyRentalCharge(), 0);
		assertEquals(3, generatedAgreement.getChargeDays());
		assertEquals(8.97, generatedAgreement.getPrediscountCharge(), 0);
		assertEquals(0, generatedAgreement.getDiscountAmount(), 0);
		assertEquals(8.97, generatedAgreement.getFinalCharge(), 0);
	}
	
	@Test
	public void testFive() throws DiscountException, DayCountException {
		Checkout checkoutFive = new Checkout("JAKR", "7/2/15", 9, 0);
		RentalAgreement generatedAgreement = CheckoutService.processCheckout(checkoutFive);
		assertNotNull(generatedAgreement);
		
		assertEquals(AvailableTool.JAKR, generatedAgreement.getTool());
		assertEquals(checkoutFive, generatedAgreement.getCheckout());
		assertEquals(LocalDate.of(2015, 7, 11), generatedAgreement.getDueDate());
		assertEquals(2.99, generatedAgreement.getDailyRentalCharge(), 0);
		assertEquals(5, generatedAgreement.getChargeDays());
		assertEquals(14.95, generatedAgreement.getPrediscountCharge(), 0);
		assertEquals(0, generatedAgreement.getDiscountAmount(), 0);
		assertEquals(14.95, generatedAgreement.getFinalCharge(), 0);
	}
	
	@Test
	public void testSix() throws DiscountException, DayCountException {
		Checkout checkoutSix = new Checkout("JAKR", "7/2/20", 4, 50);
		RentalAgreement generatedAgreement = CheckoutService.processCheckout(checkoutSix);
		assertNotNull(generatedAgreement);
		
		assertEquals(AvailableTool.JAKR, generatedAgreement.getTool());
		assertEquals(checkoutSix, generatedAgreement.getCheckout());
		assertEquals(LocalDate.of(2020, 7, 6), generatedAgreement.getDueDate());
		assertEquals(2.99, generatedAgreement.getDailyRentalCharge(), 0);
		assertEquals(1, generatedAgreement.getChargeDays());
		assertEquals(2.99, generatedAgreement.getPrediscountCharge(), 0);
		assertEquals(1.50, generatedAgreement.getDiscountAmount(), 0);
		assertEquals(1.49, generatedAgreement.getFinalCharge(), 0);
	}
	
	@Test(expected = DayCountException.class)
	public void testSeven() throws DiscountException, DayCountException {
		Checkout checkoutOne = new Checkout("JAKR", "9/3/15", 0, 10);
		CheckoutService.processCheckout(checkoutOne);
	}
}
