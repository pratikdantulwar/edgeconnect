package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

public class IssueListingPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public IssueListingPageLocators(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getCreateIssueButtonId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//div[@class='fab']");
    }

    public Object getIssueTitleId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("(//h6[@class='title']//b)[1]");
    }

}
