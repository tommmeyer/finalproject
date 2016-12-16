package exceptions;

import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;
import rocket.app.view.MortgageController;

public class RateException extends Exception {
	
	private LoanRequest badLoan;
	private String errorMessage;
	private MortgageController client;
	
	public RateException(LoanRequest lq, String problem){
		this.badLoan = lq;
		this.errorMessage = problem;
		this.badLoan.setErrorMessage(this.errorMessage);
		this.badLoan.setIsAccepted(false);
	}
	public RateException(LoanRequest lq, String problem, MortgageController mc){
		this(lq, problem);
		this.client = mc;
		mc.HandleLoanRequestDetails(lq);
	}
	

	public LoanRequest getBadLoan() {
		return badLoan;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	
}
