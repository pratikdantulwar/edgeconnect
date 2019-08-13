package com.edgeconnect.test.mobiletest;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.pageobjects.AppCommonPage;
import com.edgeconnect.mobile.pageobjects.IssueCreationPage;
import com.edgeconnect.mobile.pageobjects.IssueListingPage;
import com.edgeconnect.mobile.pageobjects.LoginSignInPage;



public class IssueCreation extends BaseTest {

	@Test(description = "Creation of new issue")
	public void issueCreation() {
		try {			
			
			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
			reporter.logInfo("Login page is opened");
				
			HashMap<String, String> testData = CommonFunctions.getData(this.toString());
						
			loginSignInPage.enterCredentialAndLogin(testData.get("userName"), testData.get("password"));
			AppCommonPage appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.clickOnIssueMenu();
			
			IssueListingPage issueListingPage = testApp.getInstance(IssueListingPage.class);
			issueListingPage.clickCreateIssueButton();
			IssueCreationPage issueCreationPage = testApp.getInstance(IssueCreationPage.class);
			String title = "Issue" + CommonFunctions.getRandomNumber();
			issueCreationPage.enterCreateIssueDetails(title, testData.get("description"), testData.get("impact"));
			
			Thread.sleep(5000);
			issueListingPage = testApp.getInstance(IssueListingPage.class);
			
			assertEquals(issueListingPage.getIssueTitleOfFirstItem().trim(), "title", "validating the newly created issue title");
			reporter.logPass("Successfully created new issue");
			
			Thread.sleep(5000);			
			appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.appLogout();
						
		} catch (Throwable th) {
				reporter.logFail("Issue creation test fail");
		}
	}
	
	
}