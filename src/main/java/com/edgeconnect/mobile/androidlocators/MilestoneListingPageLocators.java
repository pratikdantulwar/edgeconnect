package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

public class MilestoneListingPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public MilestoneListingPageLocators(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getCreateMilestoneButtonId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//div[@class='fab']");
    }

    public Object getMilestoneTitleId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("(//h6[@class='title']//b)[1]");
    }

}
