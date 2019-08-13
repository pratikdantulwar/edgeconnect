package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.mobile.androidlocators.HomePageElementProvider;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class HomePage extends TestPage {

    TestContext appiumContext;
    HomePageElementProvider searchModulePageElementProvider;

    public HomePage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
       
    }

    public void clickOnUserIcon() {
        appiumContext.waitFor(5000);
        appiumContext.click(searchModulePageElementProvider.getLoginId());
    }

    @Override
    public void initializeElementProvider() {
        searchModulePageElementProvider = new HomePageElementProvider(appiumContext);
    }
}