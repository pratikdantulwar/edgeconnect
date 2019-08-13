package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.mobile.androidlocators.IssueListingPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class IssueListingPage extends TestPage{

	TestContext appiumContext;
    IssueListingPageLocators issueListingPageLocators;
    String warnignMessage = "";

    public IssueListingPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
 
    }

    public void initializeElementProvider() {
    	issueListingPageLocators = new IssueListingPageLocators(appiumContext);
    }
    
    public void clickCreateIssueButton()
    {
    	appiumContext.click(issueListingPageLocators.getCreateIssueButtonId());
    	appiumContext.waitFor(2000);
    }
    
    public String getIssueTitleOfFirstItem()
    {
    	return appiumContext.getText(issueListingPageLocators.getIssueTitleId());
    }

}
