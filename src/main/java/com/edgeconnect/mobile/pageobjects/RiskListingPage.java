package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.mobile.androidlocators.AppCommonPageLocators;
import com.edgeconnect.mobile.androidlocators.RiskListingPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class RiskListingPage extends TestPage{

	 TestContext appiumContext;
	 RiskListingPageLocators riskListingPageLocators;
	
	public RiskListingPage(TestContext context) {
		super(context);
		if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
        
	}

	@Override
	public void initializeElementProvider() {
		riskListingPageLocators = new RiskListingPageLocators(appiumContext);
	}

	public void clickOnCreateRiskButton()
    {
    	appiumContext.click(riskListingPageLocators.getCreateRiskButtonId());
    	appiumContext.waitFor(2000);
    }
	
	public String getRiskTitleOfFirstItem()
    {
    	return appiumContext.getText(riskListingPageLocators.getRiskTitleId());
    }
	
}
