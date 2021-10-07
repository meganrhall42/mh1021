package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import main.model.Checkout;
import main.model.RentalAgreement;
import main.service.CheckoutService;

public class CheckoutServiceTest {
	
	@Test
	public void testOne() {
		Checkout checkoutOne = new Checkout("JAKR", "9/3/15", 5, 101);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutOne);
		assertNotNull(agreement);
	}
	
	@Test
	public void testTwo() {
		Checkout checkoutTwo = new Checkout("LADW", "7/2/20", 3, 10);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutTwo);
		assertNotNull(agreement);
	}
	
	@Test
	public void testThree() {
		Checkout checkoutThree = new Checkout("CHNS", "7/2/15", 5, 25);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutThree);
		assertNotNull(agreement);
	}
	
	@Test
	public void testFour() {
		Checkout checkoutFour = new Checkout("JAKD", "9/3/15", 6, 0);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutFour);
		assertNotNull(agreement);
	}
	
	@Test
	public void testFive() {
		Checkout checkoutFive = new Checkout("JAKR", "7/2/15", 9, 0);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutFive);
		assertNotNull(agreement);
	}
	
	@Test
	public void testSix() {
		Checkout checkoutSix = new Checkout("JAKR", "7/2/20", 4, 50);
		RentalAgreement agreement = CheckoutService.processCheckout(checkoutSix);
		assertNotNull(agreement);
	}
}
