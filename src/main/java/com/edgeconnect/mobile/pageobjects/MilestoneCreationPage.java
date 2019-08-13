package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.androidlocators.IssueCreationPageLocators;
import com.edgeconnect.mobile.androidlocators.MilestoneCreationPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import org.openqa.selenium.support.ui.Select;
import com.taf.core.TestContext;
import com.taf.core.TestPage;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MilestoneCreationPage extends TestPage {
    TestContext appiumContext;
    MilestoneCreationPageLocators milestoneCreationPageLocators;
    String warnignMessage = "";

    public MilestoneCreationPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;

    }

    public void initializeElementProvider() {
    	milestoneCreationPageLocators = new MilestoneCreationPageLocators(appiumContext);
    }

       
    public void enterCreateMilestoneDetails(String title, String description, String percentage) {
      appiumContext.enterTextIn(milestoneCreationPageLocators.getTitleId(), title);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.enterTextIn(milestoneCreationPageLocators.getDescriptionId(), description);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.enterTextIn(milestoneCreationPageLocators.getPercentageCompletedId(), percentage);
      appiumContext.hideKeyBoard();
      appiumContext.waitFor(2000);      
      
      appiumContext.click(milestoneCreationPageLocators.getIdentifiedDateId());
      int indentfiedDate = CommonFunctions.getTodaysDate() - 2;    
	  String identifiedDateXpath = CommonFunctions.setDate(indentfiedDate);
	  appiumContext.click(milestoneCreationPageLocators.getCalanderDateId(identifiedDateXpath));	  
	  appiumContext.waitFor(2000);
	  
	  appiumContext.click(milestoneCreationPageLocators.getDueDateId());
	  String dueDateXpath = CommonFunctions.setDate(1);
	  appiumContext.click(milestoneCreationPageLocators.getCalanderDateId(dueDateXpath));	
	  appiumContext.waitFor(2000);
	  
	  appiumContext.click(milestoneCreationPageLocators.getActualStartDateId());
	  int actualStartDate = CommonFunctions.getTodaysDate() - 2;    
	  String actualStartDateXpath = CommonFunctions.setDate(actualStartDate);
	  appiumContext.click(milestoneCreationPageLocators.getCalanderDateId(actualStartDateXpath));	  
	  appiumContext.waitFor(2000);	  
	  
	  appiumContext.click(milestoneCreationPageLocators.getActualEndDateId());
	  int actualEndDate = CommonFunctions.getTodaysDate() - 2;    
	  String actualEndDateXpath = CommonFunctions.setDate(actualEndDate);
	  appiumContext.click(milestoneCreationPageLocators.getCalanderDateId(actualEndDateXpath));	  
	  appiumContext.waitFor(2000);
	  
	  setCriticality();
	  appiumContext.waitFor(2000);
	  setRagStatus();
	  appiumContext.waitFor(2000); 	  
      setAssignedOwner();
      appiumContext.waitFor(2000);      
      setIssue();
      appiumContext.waitFor(2000);
      setRisk();
      appiumContext.waitFor(2000);
      appiumContext.click(milestoneCreationPageLocators.getSubmitButtonId());
  }
    
    public void selectByText(WebElement element, String text) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(text);
	}
    
    public void setAssignedOwner()
    {  	
    	if(milestoneCreationPageLocators.getListOfAssignedOwner().size() > 0) {		
			List<WebElement> assignedOwnerList = milestoneCreationPageLocators.getListOfAssignedOwner();	
			String owner = assignedOwnerList.get(2).getText();	
			selectByText((WebElement) milestoneCreationPageLocators.getAssignedOwnerId(), assignedOwnerList.get(2).getText());
		}
    }
    
    public void setIssue()
	{
		if(milestoneCreationPageLocators.getListOfIssues().size() > 0) {		
			List<WebElement> issueList = milestoneCreationPageLocators.getListOfIssues();			
			selectByText((WebElement) milestoneCreationPageLocators.getIssueId(), issueList.get(2).getText());
		}
	} 
    
    public void setRisk()
  	{
  		if(milestoneCreationPageLocators.getListOfRisks().size() > 0) {		
  			List<WebElement> riskList = milestoneCreationPageLocators.getListOfRisks();			
  			selectByText((WebElement) milestoneCreationPageLocators.getRiskId(), riskList.get(2).getText());
  		}
  	} 
    
    public void setCriticality()
    {  	
    	if(milestoneCreationPageLocators.getListOfCriticality().size() > 0) {		
  			List<WebElement> criticalityList = milestoneCreationPageLocators.getListOfCriticality();			
  			selectByText((WebElement) milestoneCreationPageLocators.getCrticalityId(), criticalityList.get(2).getText());
  		}
    }
    
    public void setRagStatus()
    {  	
    	if(milestoneCreationPageLocators.getListOfRagStatus().size() > 0) {		
  			List<WebElement> ragStatusList = milestoneCreationPageLocators.getListOfRagStatus();			
  			selectByText((WebElement) milestoneCreationPageLocators.getRagStatusId(), ragStatusList.get(2).getText());
  		}
    }
    
}