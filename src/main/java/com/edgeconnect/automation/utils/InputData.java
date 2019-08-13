package com.edgeconnect.automation.utils;

public class InputData {
	
	public int iTestCaseRow;	
	public String userName;    
	public String passowrd;
	public String issueDescription;
	public String issueImpact;
	
	int getiTestCaseRow() {return this.iTestCaseRow;}
	int setiTestCaseRow(int iTestCaseRow) {return this.iTestCaseRow = iTestCaseRow;}
	
	String getuserName() {return this.userName;}
	String setuserName(String  userName) {return this.userName = userName;}
	
	String getpassowrd() {return this.passowrd;}
	String setpassowrd(String passowrd) {return this.passowrd = passowrd;}
	
	public String getissueDescription() {return this.issueDescription;}
	public String setissueDescription(String issueDescription) {return this.issueDescription = issueDescription;}
	
	String getissueImpact() {return this.issueImpact;}
	String setissueImpact(String iTestCaseRow) {return this.issueImpact = issueImpact;}
	
}
