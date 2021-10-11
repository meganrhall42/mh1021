package main.model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RentalAgreement {

	private AvailableTool tool;
	private Checkout checkout;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double prediscountCharge;
	private double discountAmount;
	private double finalCharge;
	
	public RentalAgreement() { }
	
	public RentalAgreement(AvailableTool tool, Checkout checkout, LocalDate dueDate, double dailyRentalCharge,
			int chargeDays, double prediscountCharge, double discountAmount, double finalCharge) {
		this.tool = tool;
		this.checkout = checkout;
		this.dueDate = dueDate;
		this.dailyRentalCharge = dailyRentalCharge;
		this.chargeDays = chargeDays;
		this.prediscountCharge = prediscountCharge;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}

	public AvailableTool getTool() {
		return tool;
	}

	public void setTool(AvailableTool tool) {
		this.tool = tool;
	}

	public Checkout getCheckout() {
		return checkout;
	}

	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public void setDailyRentalCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}

	public int getChargeDays() {
		return chargeDays;
	}

	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}

	public double getPrediscountCharge() {
		return prediscountCharge;
	}

	public void setPrediscountCharge(double prediscountCharge) {
		this.prediscountCharge = prediscountCharge;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getFinalCharge() {
		return finalCharge;
	}

	public void setFinalCharge(double finalCharge) {
		this.finalCharge = finalCharge;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		str.append("Tool code: " + tool.getToolCode() + "\n");
		str.append("Tool type: " + tool.getType().getType() + "\n");
		str.append("Tool brand: " + tool.getBrand() + "\n");
		str.append("Rental days: " + checkout.getRentalDayCount() + "\n");
		str.append("Check out date: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(checkout.getCheckoutDate()) + "\n");
		str.append("Due date: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dueDate) + "\n");
		str.append("Daily rental charge: " + currencyFormat.format(dailyRentalCharge) + "\n");
		str.append("Charge days: " + chargeDays + "\n");
		str.append("Prediscount charge: " + currencyFormat.format(prediscountCharge) + "\n");
		str.append("Discount percent: " + checkout.getDiscount() + "%\n");
		str.append("Discount amount: " + currencyFormat.format(discountAmount) + "\n");
		str.append("Final charge: " + currencyFormat.format(finalCharge) + "\n");
		
		
		return str.toString();
	}
	
}
