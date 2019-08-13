package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

public class LoginSignInPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public LoginSignInPageLocators(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getUsernameId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//input[@id='email']");
    }

    public Object getPasswordId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("//input[@id= 'pwd']");
    }

    public Object getLoginButtonId() {
        return appiumAndroidElementProvider.getElementByXpath("//button[@id='loadButton']");
    }
    
    public Object getWarningMessageId() {
        return appiumAndroidElementProvider.getElementByXpath("//h6[@class='text-warning text-center']");
    }

//    public Object getRegisterBtnId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/loginRegisterBtn");
//    }
//
//    public Object getFBLoginId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/fbLogin");
//    }
//
//    public Object geGoogleLoginId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/googleLogin");
//    }
//
//    public Object getSignUpEmailId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/signUp");
//    }
//
//    public Object getFNameId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/registerFNameET");
//    }
//
//    public Object getLastNameId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/registerLNameET");
//    }
//
//    public Object getRegisterEmailId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/registerEmailET");
//    }
//
//    public Object getRegisterPassId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/registerPassET");
//    }
//
//    public Object getExitButtonId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/btnExit");
//    }
//
//    public Object getEmailVerificationId() {
//        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/messageFirstLine");
//    }
}
