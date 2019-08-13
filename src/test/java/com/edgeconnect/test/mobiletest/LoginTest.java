package com.edgeconnect.test.mobiletest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.automation.utils.InputData;
import com.edgeconnect.mobile.pageobjects.AppCommonPage;
import com.edgeconnect.mobile.pageobjects.LoginSignInPage;

public class LoginTest extends BaseTest {

	
	@Test(description = "Verify Valid Login - Happy Path", enabled=false)
	public void verifyLogin() {
//		try {
			
			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
			reporter.logPass("Login page opened successfully");
			loginSignInPage.enterCredentialAndLogin(configData.getProperty("username"), configData.getProperty("password"));
			reporter.logInfo("Entered username: " + configData.getProperty("username") + " password: " + configData.getProperty("password"));
			reporter.logPass("Successfully Logged in");
			AppCommonPage appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.appLogout();
			reporter.logInfo("Called Log Out Function");
			reporter.logPass("Login and Logout done successfully");
//		} catch (Throwable th) {
//
//		}
	}
	
	@Test(description = "Verify Login with invalid username", priority=2)
	public void verifyInvaldUserNameLogin() {
//		try {	
		
			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
			reporter.logPass("Login page opened successfully");
			loginSignInPage.enterCredentialAndLogin(CommonFunctions.getRandomString(), "Test");
			Assert.assertEquals(loginSignInPage.getWarningMessage(), "Please enter valid username/email/password1" , "Validating the error for invalid id");
			reporter.logPass("Warning message verified for invalid login username : " + loginSignInPage.getWarningMessage());
//		} catch (Throwable th) {
//			System.out.print(th.getMessage());
//		}
			
	}
	
//	@Test(description = "Verify Login with blank username")
//	public void verifyBlankUserNameLogin() {
//		try {
//			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
//			reporter.logPass("Login page opened successfully");
//			loginSignInPage.enterCredentialAndLogin("", "Test");
//			Assert.assertEquals(loginSignInPage.getWarningMessage(), "Please enter valid username/email", "Validating the error for blank id");
//			reporter.logPass("Warning message verified for blank username : " + loginSignInPage.getWarningMessage());
//		} catch (Throwable th) {
//
//		}
//	}
//	
//	@Test(description = "Verify Login with blank password")
//	public void verifyBlankPwdLogin() {
//		try {
//			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
//			reporter.logPass("Login page opened successfully");
//			loginSignInPage.enterCredentialAndLogin("", "Test");
//			Assert.assertEquals(loginSignInPage.getWarningMessage(), "Please enter valid password", "Validating the error for blank pwd");
//			reporter.logPass("Warning message verified for blank pwd : " + loginSignInPage.getWarningMessage());
//		} catch (Throwable th) {
//
//		}
//	}
}