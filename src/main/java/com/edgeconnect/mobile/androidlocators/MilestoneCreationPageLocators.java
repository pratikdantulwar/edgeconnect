package com.edgeconnect.mobile.androidlocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

import io.appium.java_client.android.AndroidElement;

public class MilestoneCreationPageLocators extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public MilestoneCreationPageLocators(TestContext context) {
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
       
    public Object getPercentageCompletedId() {
        return appiumAndroidElementProvider
        		 .getElementByXpath("//input[@formcontrolname='percentage']");
    }
    
    public Object getIdentifiedDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='identifiedDate']");
    }
    
    public Object getDueDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='dueDate']");
    }
    
    public Object getActualStartDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='actualStartDate']");
    }
    
    public Object getActualEndDateId() {
        return appiumAndroidElementProvider.getElementByXpath("//ec-datepicker[@formcontrolname='actualEndDate']");
    }

    public Object getCrticalityId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='criticality']");
    }
    
    public Object getRagStatusId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='ragStatus']");
    }
    
    public Object getAssignedOwnerId() {
        return appiumAndroidElementProvider.getElementByXpath("//select[@formcontrolname='assignedTo']");
    }
    
    public Object getIssueId() {
        return  appiumAndroidElementProvider.getElementByXpath("//ng-multiselect-dropdown[@formcontrolname='issuesList']");        
    }
    
    public Object getRiskId() {
        return  appiumAndroidElementProvider.getElementByXpath("//ng-multiselect-dropdown[@formcontrolname='risksList']");        
    }
    
    public Object getSubmitButtonId() {
        return  appiumAndroidElementProvider.getElementByXpath("//button[@class='btn btn-warning btn-lg btn-block btn-block-rounded']");
        
    }
    
    public List<WebElement> getListOfCriticality() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='criticality']//option"));
    }
    
    public List<WebElement> getListOfRagStatus() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='ragStatus']//option"));
    }
    
    public List<WebElement> getListOfAssignedOwner() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//select[@formcontrolname='assignedTo']//option"));
    }
     
    public List<WebElement> getListOfIssues() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//ng-multiselect-dropdown[@formcontrolname='issuesList']//input[@type='checkbox']"));
    }
    
    public List<WebElement> getListOfRisks() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//ng-multiselect-dropdown[@formcontrolname='risksList']//input[@type='checkbox']"));
    }
    
    public Object getCalanderDateId(String date) {
        return appiumAndroidElementProvider.getElementByXpath(date);
    }    
}
