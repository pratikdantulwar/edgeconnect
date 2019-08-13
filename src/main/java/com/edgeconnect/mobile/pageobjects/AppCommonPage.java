package com.edgeconnect.mobile.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edgeconnect.mobile.androidlocators.AppCommonPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class AppCommonPage extends TestPage {
    TestContext appiumContext;
    AppCommonPageLocators appCommonPageLocators;

    
    
    public AppCommonPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
       
    }

    public void initializeElementProvider() {
    	appCommonPageLocators = new AppCommonPageLocators(appiumContext);
    }

    public void appLogout() {
        appiumContext.click(appCommonPageLocators.getHamburgerMenuId());
        appiumContext.waitFor(2000);
        appiumContext.click(appCommonPageLocators.getLogoutMenuId());
        appiumContext.waitFor(2000);
        appiumContext.click(appCommonPageLocators.getYesButtonId());
        appiumContext.waitFor(2000);
    }

    public void clickOnIssueMenu() {
    	appiumContext.click(appCommonPageLocators.getHamburgerMenuId());
        appiumContext.waitFor(2000);
        appiumContext.click(appCommonPageLocators.getIssueMenuId());
        appiumContext.waitFor(2000);
    }
    
    public void clickOnRiskMenu() {
    	appiumContext.click(appCommonPageLocators.getHamburgerMenuId());
        appiumContext.waitFor(2000);
        appiumContext.click(appCommonPageLocators.getRiskMenuId());
        appiumContext.waitFor(2000);
    }
    
    public void clickOnMilestoneMenu() {
    	appiumContext.click(appCommonPageLocators.getHamburgerMenuId());
        appiumContext.waitFor(2000);
        appiumContext.click(appCommonPageLocators.getMilestoneMenuId());
        appiumContext.waitFor(2000);
    }
    
    
//    public boolean isFBLoginDisplayed() {
//        return appiumContext.isDisplayed(loginSignInPageLocators.getFBLoginId());
//    }
//
//    public boolean isLoginGoogleDisplayed() {
//        return appiumContext.isDisplayed(loginSignInPageLocators.getFBLoginId());
//    }
//
//    public boolean isSignUpEmailDisplayed() {
//        return appiumContext.isDisplayed(loginSignInPageLocators.getFBLoginId());
//    }
//
//    public void clickOnSignUpEmail() {
//        appiumContext.waitFor(2000);
//        appiumContext.click(loginSignInPageLocators.getSignUpEmailId());
//        appiumContext.waitFor(2000);
//    }
//
//    public void enterRegisterDetails(String fName, String lName, String email, String pass) {
//        appiumContext.enterTextIn(loginSignInPageLocators.getFNameId(), fName);
//        appiumContext.waitFor(2000);
//        appiumContext.hideKeyBoard();
//        appiumContext.enterTextIn(loginSignInPageLocators.getLastNameId(), lName);
//        appiumContext.waitFor(2000);
//        appiumContext.hideKeyBoard();
//        appiumContext.enterTextIn(loginSignInPageLocators.getRegisterEmailId(), email);
//        appiumContext.hideKeyBoard();
//        appiumContext.waitFor(2000);
//        appiumContext.enterTextIn(loginSignInPageLocators.getRegisterPassId(), pass);
//        appiumContext.waitFor(2000);
//        appiumContext.hideKeyBoard();
//        appiumContext.waitFor(2000);
//    }
//
//    public boolean isRegistrationFormOpened() {
//        return appiumContext.isDisplayed(loginSignInPageLocators.getFNameId());
//    }
//
//    public boolean clickOnExitButton() {
//        appiumContext.waitFor(3000);
//        if (!appiumContext.isDisplayed(loginSignInPageLocators.getExitButtonId()))
//            return false;
//        appiumContext.click(loginSignInPageLocators.getExitButtonId());
//        return true;
//    }
//
//    public void enterFirstName(String fName) {
//        appiumContext.clear(loginSignInPageLocators.getFNameId());
//        appiumContext.hideKeyBoard();
//        appiumContext.enterTextIn(loginSignInPageLocators.getFNameId(), fName);
//        appiumContext.hideKeyBoard();
//    }
//
//    public boolean isUserRegistered() {
//        appiumContext.waitFor(2000);
//        return appiumContext.isDisplayed(loginSignInPageLocators.getEmailVerificationId());
//    }
}