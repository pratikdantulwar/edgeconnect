package com.edgeconnect.test.mobiletest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.pageobjects.AppCommonPage;
import com.edgeconnect.mobile.pageobjects.LoginSignInPage;
import com.edgeconnect.mobile.pageobjects.MilestoneCreationPage;
import com.edgeconnect.mobile.pageobjects.MilestoneListingPage;

public class MilestoneCreation extends BaseTest {

	@Test(description = "Creation of new milestone")
	public void milestoneCreation() {
		try {
			
			LoginSignInPage loginSignInPage = testApp.getInstance(LoginSignInPage.class);
			loginSignInPage.enterCredentialAndLogin(configData.getProperty("username"), configData.getProperty("password"));
			AppCommonPage appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.clickOnMilestoneMenu();
			
			MilestoneListingPage milestoneListingPage = testApp.getInstance(MilestoneListingPage.class);
			milestoneListingPage.clickCreateMilestoneButton();
			MilestoneCreationPage milestoneCreationPage = testApp.getInstance(MilestoneCreationPage.class);
			String title = "Milestone" + CommonFunctions.getRandomNumber();
			milestoneCreationPage.enterCreateMilestoneDetails(title, "lets go in this direction", "55.55");
			
			Thread.sleep(5000);
		    milestoneListingPage = testApp.getInstance(MilestoneListingPage.class);
			assertEquals(milestoneListingPage.getMilestoneTitleOfFirstItem().trim(), title, "validating the newly created milestone title");
			
			Thread.sleep(5000);			
			appCommonPage = testApp.getInstance(AppCommonPage.class);
			appCommonPage.appLogout();
			//reporter.logPass("Successfully created new milestone");
			
		} catch (Throwable th) {
				System.out.println(th.getMessage());
		}
	}
	
	
}