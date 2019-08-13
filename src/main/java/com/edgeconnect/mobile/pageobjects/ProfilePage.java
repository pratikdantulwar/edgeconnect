package com.edgeconnect.mobile.pageobjects;


import com.edgeconnect.mobile.androidlocators.ProfilePageElementProvider;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.taf.core.TestContext;
import com.taf.core.TestPage;

import org.openqa.selenium.WebElement;

public class ProfilePage extends TestPage {
    TestContext appiumContext;
    ProfilePageElementProvider profilePageElementProvider;

    public ProfilePage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
  
    }

    @Override
    public void initializeElementProvider() {
        profilePageElementProvider = new ProfilePageElementProvider(appiumContext);
    }

    public ProfilePage clickOnMenuIcon() {
        appiumContext.click(profilePageElementProvider.getMenuIconId());
        return this;
    }

    public ProfilePage clickOnMenu(String menu) {
        appiumContext.click(profilePageElementProvider.getMenu(menu));
        return this;
    }

    public boolean isMenuClicked(String menu) {
        return appiumContext.isDisplayed(profilePageElementProvider.getMenu(menu));
    }

    public void logout() {
        appiumContext.click(profilePageElementProvider.logOutId());
    }

    public ProfilePage expandMenu(String menu) {
        for (WebElement element : profilePageElementProvider.getList()) {
            if (element.getText().equals(menu)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public void clickOnMyProfile() {
        appiumContext.clear(profilePageElementProvider.getMyProfileId());
    }
    public boolean getEmailVerifyStatus(){
        appiumContext.waitFor(1000);
        return appiumContext.isDisplayed(profilePageElementProvider.getEmailStatusId());
    }
}
