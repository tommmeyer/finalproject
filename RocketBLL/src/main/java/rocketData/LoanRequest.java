package rocketData;

import java.io.Serializable;
import java.util.LinkedList;

public class LoanRequest implements Serializable {

	private int iTerm;
	private double dRate;
	private double dAmount;
	private int iCreditScore;
	private int iDownPayment;
	private double dPayment;
	private double income;
	private double expenses;
	private double balloonAmount;
	private boolean pmtPeriod=true;
	private boolean isAccepted = true;
	
	
	
	
	
	//	TODO - RocketBLL.LoanRequest
	//			missing attributes...
	//			Income
	//			Expenses
	//			Add these attributes to the class... add getters and setters.
	
	public boolean getIsAccepted(){
		return this.isAccepted;
	}
	
	public void setIsAccepted(boolean acceptedOrRejected){
		this.isAccepted = acceptedOrRejected;
	}
	
	public boolean getPmtPeriod() {
		return this.pmtPeriod;
	}
	public void setPmtPeriod(boolean pmtPeriod) {
		this.pmtPeriod = pmtPeriod;
	}
	public double getBalloonAmount() {
		return balloonAmount;
	}
	public void setBalloonAmount(double balloonAmount) {
		this.balloonAmount = balloonAmount;
	}
	public LoanRequest() {
		super();
	}
	public int getiTerm() {
		return iTerm;
	}
	public void setiTerm(int iTerm) {
		this.iTerm = iTerm;
	}
	public double getdRate() {
		return dRate;
	}
	public void setdRate(double dRate) {
		this.dRate = dRate;
	}
	public double getdAmount() {
		return dAmount;
	}
	public void setdAmount(double dAmount) {
		this.dAmount = dAmount;
	}
	public int getiCreditScore() {
		return iCreditScore;
	}
	public void setiCreditScore(int iCreditScore) {
		this.iCreditScore = iCreditScore;
	}
	public int getiDownPayment() {
		return iDownPayment;
	}
	public void setiDownPayment(int iDownPayment) {
		this.iDownPayment = iDownPayment;
	}
	public double getdPayment() {
		return dPayment;
	}
	public void setdPayment(double dPayment) {
		this.dPayment = dPayment;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
}
