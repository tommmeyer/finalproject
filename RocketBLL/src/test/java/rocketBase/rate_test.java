package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;
import rocketData.LoanRequest;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void getRateTest() throws RateException {
		LoanRequest knownLoan = new LoanRequest();
		knownLoan.setBalloonAmount(0);
		knownLoan.setdAmount(300000);
		knownLoan.setExpenses(0);
		knownLoan.setiTerm(360);
		knownLoan.setExpenses(0);
		knownLoan.setiDownPayment(0);
		knownLoan.setIncome(10000);
		knownLoan.setPmtPeriod(true);
		knownLoan.setiCreditScore(725);
		assertEquals(RateBLL.getRate(knownLoan),.04,.001);
	}
	
	@Test
	public void getPaymentTest() throws RateException {
		LoanRequest knownLoan = new LoanRequest();
		knownLoan.setBalloonAmount(0);
		knownLoan.setdAmount(300000);
		knownLoan.setExpenses(0);
		knownLoan.setiTerm(360);
		knownLoan.setExpenses(0);
		knownLoan.setiDownPayment(0);
		knownLoan.setIncome(10000);
		knownLoan.setPmtPeriod(true);
		knownLoan.setiCreditScore(725);
		assertEquals(RateBLL.getPayment(RateBLL.getRate(knownLoan),knownLoan.getiTerm(), knownLoan.getdAmount(), knownLoan.getBalloonAmount(), knownLoan.getPmtPeriod()),1432.25,.01);
	}
	
	@Test (expected = RateException.class)
	public void badCreditTest() throws RateException{
		LoanRequest knownLoan = new LoanRequest();
		knownLoan.setBalloonAmount(0);
		knownLoan.setdAmount(300000);
		knownLoan.setExpenses(0);
		knownLoan.setiTerm(360);
		knownLoan.setExpenses(0);
		knownLoan.setiDownPayment(0);
		knownLoan.setIncome(10000);
		knownLoan.setPmtPeriod(true);
		knownLoan.setiCreditScore(550);
		RateBLL.getRate(knownLoan);
	}

}
