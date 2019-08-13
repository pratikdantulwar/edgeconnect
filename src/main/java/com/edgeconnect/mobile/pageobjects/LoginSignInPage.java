package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.mobile.androidlocators.LoginSignInPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import com.taf.core.TestContext;
import com.taf.core.TestPage;

public class LoginSignInPage extends TestPage {
    TestContext appiumContext;
    LoginSignInPageLocators loginSignInPageLocators;
    String warnignMessage = "";

    public LoginSignInPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;

    }

    public void initializeElementProvider() {
        loginSignInPageLocators = new LoginSignInPageLocators(appiumContext);
    }

   
    
    public String getWarningMessage()
    {
    	warnignMessage = appiumContext.getText(loginSignInPageLocators.getWarningMessageId());
    	return warnignMessage;
    }
    
    public void enterCredentialAndLogin(String uName, String pass) {
        appiumContext.enterTextIn(loginSignInPageLocators.getUsernameId(), uName);
        appiumContext.waitFor(2000);
        appiumContext.hideKeyBoard();
        appiumContext.enterTextIn(loginSignInPageLocators.getPasswordId(), pass);
        appiumContext.hideKeyBoard();
        appiumContext.waitFor(2000);
        appiumContext.click(loginSignInPageLocators.getLoginButtonId());
    }

//    public void clickOnSignUpButton() {
//        appiumContext.click(loginSignInPageLocators.getRegisterBtnId());
//    }
//
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