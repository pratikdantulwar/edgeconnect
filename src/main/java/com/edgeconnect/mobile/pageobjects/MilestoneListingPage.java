package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.mobile.androidlocators.MilestoneListingPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class MilestoneListingPage extends TestPage{

	TestContext appiumContext;
    MilestoneListingPageLocators milestoneListingPageLocators;
    String warnignMessage = "";

    public MilestoneListingPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;

    }

    public void initializeElementProvider() {
    	milestoneListingPageLocators = new MilestoneListingPageLocators(appiumContext);
    }
    
    public void clickCreateMilestoneButton()
    {
    	appiumContext.click(milestoneListingPageLocators.getCreateMilestoneButtonId());
    	appiumContext.waitFor(2000);
    }
    
    public String getMilestoneTitleOfFirstItem()
    {
    	return appiumContext.getText(milestoneListingPageLocators.getMilestoneTitleId());
    }

}
