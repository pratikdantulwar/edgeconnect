package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

public class AppCommonPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public AppCommonPageLocators(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getHamburgerMenuId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//ec-header/nav/div/button");
    }

    public Object getLogoutMenuId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("//a[contains(.,'Logout')]");
    }

    public Object getIssueMenuId() {
        return appiumAndroidElementProvider.getElementByXpath("//a[contains(.,'Issue')]");
    }
    
    public Object getRiskMenuId() {
        return appiumAndroidElementProvider.getElementByXpath("//a[contains(.,'Risk')]");
    }
    
    public Object getMilestoneMenuId() {
        return appiumAndroidElementProvider.getElementByXpath("//a[contains(.,'Milestone')]");
    }
    
    public Object getYesButtonId() {
        return appiumAndroidElementProvider.getElementByXpath("//button[contains(.,'Yes')]");
    }
    
    public Object getNoButtonId() {
        return appiumAndroidElementProvider.getElementByXpath("//button[@type='No']");
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
