package com.edgeconnect.mobile.androidlocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

import io.appium.java_client.android.AndroidElement;

public class RiskCreationPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public RiskCreationPageLocators(TestContext context) {
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
       
    public Object getIdentifiedDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='plannedStartDate']");
    }
    
    public Object getDueDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='plannedEndDate']");
    }

    public Object getAssignedOwnerId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='assignedTo']");
    }
    
    public Object getMilestoneId() {
        return  appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='milestone']");        
    }
    
    public Object getSubmitButtonId() {
        return  appiumAndroidElementProvider.getElementByXpath("//button[@class='btn btn-warning btn-lg btn-block btn-block-rounded']");
        
    }
    
    public List<WebElement> getListOfAssignedOwner() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='assignedTo']//option"));
    }
     
    public List<WebElement> getListOfMilestone() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='milestone']//option"));
    }
    
    public Object getCalanderDateId(String date) {
        return appiumAndroidElementProvider.getElementByXpath(date);
    }    
}
