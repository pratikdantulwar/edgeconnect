package com.edgeconnect.mobile.androidlocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

import io.appium.java_client.android.AndroidElement;

public class IssueCreationPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public IssueCreationPageLocators(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getTitleId() {
        return appiumAndroidElementProvider
                .getElementByXpath("//input[@formcontrolname='title']");
    }

    public Object getDescriptionId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("//textarea[@formcontrolname='description']");
    }
    
    public Object getImpactId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("//input[@formcontrolname='impact']");
    }

    public Object getIdentifiedDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='plannedStartDate']");
    }
    
    public Object getDueDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='plannedEndDate']");
    }

    public Object getAssignedOwnerId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='assignedTo']");
    }
    
    public Object getSeverityId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='severity']");
    }
    
    public Object getMilestoneId() {
        return  appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='milestoneList']");
        
    }
    
    public Object getSubmitButtonId() {
        return  appiumAndroidElementProvider.getElementByXpath("//button[@class='btn btn-warning btn-lg btn-block btn-block-rounded']");
        
    }
    
    public List<WebElement> getListOfAssignedOwner() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='assignedTo']//option"));
    }
    
    public List<WebElement> getListOfSeverity() {
        //return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='severity']//option[@class='ng-star-inserted']"));
    	return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='severity']//option"));
    }
    
    public List<WebElement> getListOfMilestone() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='milestoneList']//option"));
    }
    
    public Object getCalanderDateId(String date) {
        return appiumAndroidElementProvider.getElementByXpath(date);
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
