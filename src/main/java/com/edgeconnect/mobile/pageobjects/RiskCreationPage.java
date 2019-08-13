package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.androidlocators.RiskCreationPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import org.openqa.selenium.support.ui.Select;
import com.taf.core.TestContext;
import com.taf.core.TestPage;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RiskCreationPage extends TestPage {
    TestContext appiumContext;
    RiskCreationPageLocators riskCreationPageLocators;
    String warnignMessage = "";

    public RiskCreationPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
        
    }

    public void initializeElementProvider() {
    	riskCreationPageLocators = new RiskCreationPageLocators(appiumContext);
    }

       
    public void enterCreateRiskDetails(String title, String description) {
      appiumContext.enterTextIn(riskCreationPageLocators.getTitleId(), title);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.enterTextIn(riskCreationPageLocators.getDescriptionId(), description);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.waitFor(2000);      
      
      appiumContext.click(riskCreationPageLocators.getIdentifiedDateId());
      int indentfiedDate = CommonFunctions.getTodaysDate() - 2;    
	  String DateXpath = CommonFunctions.setDate(indentfiedDate);
	  appiumContext.click(riskCreationPageLocators.getCalanderDateId(DateXpath));	  
	  appiumContext.waitFor(2000);
	  
	  appiumContext.click(riskCreationPageLocators.getDueDateId());
	  String DateXpath1 = CommonFunctions.setDate(1);
	  appiumContext.click(riskCreationPageLocators.getCalanderDateId(DateXpath1));	
	  appiumContext.waitFor(2000);
	  
      setAssignedOwner();
      appiumContext.waitFor(2000);

      setMilestone();
      appiumContext.waitFor(2000);
      appiumContext.click(riskCreationPageLocators.getSubmitButtonId());
  }
    
    public void selectByText(WebElement element, String text) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(text);
	}
    
    public void setAssignedOwner()
    {  	
    	if(riskCreationPageLocators.getListOfAssignedOwner().size() > 0) {		
			List<WebElement> assignedOwnerList = riskCreationPageLocators.getListOfAssignedOwner();	
			selectByText((WebElement) riskCreationPageLocators.getAssignedOwnerId(), assignedOwnerList.get(2).getText());
		}
    }
    
    public void setMilestone()
	{
		if(riskCreationPageLocators.getListOfMilestone().size() > 0) {		
			List<WebElement> milestoneList = riskCreationPageLocators.getListOfMilestone();			
			selectByText((WebElement) riskCreationPageLocators.getMilestoneId(), milestoneList.get(2).getText());
		}
	} 
}