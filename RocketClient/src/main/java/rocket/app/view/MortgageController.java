package rocket.app.view;

import java.util.LinkedList;

import eNums.eAction;
import exceptions.RateException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {
//NOTE my eclipse problems are creating an error when I try to open up FXML files in scenebuilder
//I attempted to attach controllers via FXML document as best as I could
	@FXML
	private MainApp mainApp;
	@FXML
	private TextField creditScoreField;
	@FXML
	private TextField loanTotalField;
	@FXML
	private TextField downPaymentField;
	@FXML
	private TextField balloonAmountField;
	@FXML
	private TextField incomeField;
	@FXML
	private TextField expensesField;
	@FXML
	private ComboBox<String> loanPeriodField;
	@FXML
	private ComboBox<String> payPeriodField;
	@FXML
	private Label outputField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	
	
	private ObservableList<String> periods =  FXCollections.observableArrayList("30 Years","15 Years");
	loanPeriodField = new ComboBox(periods);
	loanPeriodField.getSelectionModel().selectFirst();
	private ObservableList<String> paymentSchedule =  FXCollections.observableArrayList("end","beginning");
	payPeriodField = new ComboBox(paymetSchedule);
	payPeriodField.getSelectionModel().selectFirst();
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event) throws RateException{
		Object message = null;

		
		if(creditScoreField.getText() != null && Double.parseDouble(creditScoreField.getText())>=300 && Double.parseDouble(creditScoreField.getText())<=850){
			int creditScore =
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();

		if(creditScoreField.getText() != null && Integer.parseInt(creditScoreField.getText())>=300 && Integer.parseInt(creditScoreField.getText())<=850){
			lq.setiCreditScore(Integer.parseInt(creditScoreField.getText()));
		}
		else{
			
			throw new RateException(lq, "Enter a Valid Credit Score between 300 and 850", this);
		}
		if(loanTotalField.getText()!= null && Double.parseDouble(loanTotalField.getText())>0){
			lq.setdAmount(Double.parseDouble(loanTotalField.getText()));
		}
		else{
			throw new RateException(lq,"Enter a positive value for the loan",this);
		}
		if(downPaymentField.getText()!= null && Integer.parseInt(downPaymentField.getText())>0){
			lq.setiDownPayment(Integer.parseInt(downPaymentField.getText()));
		}
		else{
			throw new RateException(lq, "Enter a positive value for the down payment", this);
		}
		
		if(balloonAmountField.getText()!= null && Double.parseDouble(balloonAmountField.getText())>0){
			lq.setBalloonAmount(Double.parseDouble(loanTotalField.getText()));
		}
		else{
			throw new RateException(lq, "Enter a positive value for the balloon amount", this);
		}
		if(incomeField.getText()!= null && Double.parseDouble(incomeField.getText())>=0){
			lq.setdAmount(Double.parseDouble(incomeField.getText()));
		}
		else{
			throw new RateException(lq, "Enter a positive value for Income", this);
		}
		
		if(expensesField.getText()!= null && Double.parseDouble(expensesField.getText())>=0){
			lq.setdAmount(Double.parseDouble(expensesField.getText()));
		}
		else{
			throw new RateException(lq, "Enter a positive value for expenses", this);
		}
		if(loanPeriodField.getValue()== "15 Years"){
			lq.setiTerm(180);
		}
		else{
			lq.setiTerm(360);
		}
		if(payPeriodField.getValue() == "beginning"){
			lq.setPmtPeriod(false);
		}
		else{
			lq.setPmtPeriod(true);
		}

		a.setLoanRequest(lq);		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest) throws RateException
	{	
		if (lRequest.getIsAccepted() == false){
			outputField.setText(lRequest.getErrorMessage());
		}
		else if(lRequest.isHouseTooExpensive() == true){
			throw new RateException(lRequest, "House is too Expensive", this);
		}
		else{
			outputField.setText("Your monthly payment is $" +String.format( "%.2f", lRequest.getdPayment()));
		}
	}
	public void btnCancel(ActionEvent event){
		this.mainApp.stop();
		this.mainApp.EndPoker();
	}
}


