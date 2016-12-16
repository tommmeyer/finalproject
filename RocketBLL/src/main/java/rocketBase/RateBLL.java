package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(LoanRequest lq) throws RateException 
	{	ArrayList<RateDomainModel> rateArray = RateDAL.getAllRates();
		int GivenCreditScore = lq.getiCreditScore();
		double interest=-1;
		for(RateDomainModel rate: rateArray){
			if(GivenCreditScore >= rate.getiMinCreditScore()){
				interest = rate.getdInterestRate();
				
			}
			else{
				break;
			}
		}
		if (interest == -1){
			throw new RateException(lq, "Credit Score too Low");
		}
		return interest;
			
		
		
	}
	
	
	
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
