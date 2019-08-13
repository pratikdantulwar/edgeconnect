package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

public class RiskListingPageLocators extends PageElementProvider {

	AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;
	
	public RiskListingPageLocators(TestContext context) {
		super(context);
		// TODO Auto-generated constructor stub
		appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
	}
	
	public Object getCreateRiskButtonId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//div[@class='fab']");
    }

	public Object getRiskTitleId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("(//h6[@class='title']//b)[1]");
    }
}
