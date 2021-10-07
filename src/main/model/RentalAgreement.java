package main.model;

import java.time.LocalDate;

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
		//TODO: Change to fit desired format
		return "RentalAgreement [tool=" + tool + ", checkout=" + checkout + ", dueDate=" + dueDate
				+ ", dailyRentalCharge=" + dailyRentalCharge + ", chargeDays=" + chargeDays + ", prediscountCharge="
				+ prediscountCharge + ", discountAmount=" + discountAmount + ", finalCharge=" + finalCharge + "]";
	}
	
}
