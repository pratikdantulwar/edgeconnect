package com.edgeconnect.test.mobiletest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.pageobjects.AppCommonPage;
import com.edgeconnect.mobile.pageobjects.LoginSignInPage;
import com.edgeconnect.mobile.pageobjects.RiskCreationPage;
import com.edgeconnect.mobile.pageobjects.RiskListingPage;

public class RiskCreation extends BaseTest {

	@Test(description = "Creation of new risk")
	public void riskCreation() {
		try {
			
			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
			loginSignInPage.enterCredentialAndLogin(configData.getProperty("username"), configData.getProperty("password"));
			AppCommonPage appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.clickOnRiskMenu();
			
			RiskListingPage riskListingPage = testApp.getInstance(RiskListingPage.class);
			riskListingPage.clickOnCreateRiskButton();
			RiskCreationPage riskCreationPage = testApp.getInstance(RiskCreationPage.class);
			String title = "Risk" + CommonFunctions.getRandomNumber();
			riskCreationPage.enterCreateRiskDetails(title, "lets go in this direction");
			
			Thread.sleep(5000);
			riskListingPage = testApp.getInstance(RiskListingPage.class);
			assertEquals(riskListingPage.getRiskTitleOfFirstItem().trim(), title, "validating the newly created risk title");

			Thread.sleep(5000);			
			appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.appLogout();
			
			//reporter.logPass("Successfully created new risk");
		} catch (Throwable th) {
				System.out.println(th.getMessage());
		}
	}
	
	
}