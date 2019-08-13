package com.edgeconnect.mobile.pageobjects;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.mobile.androidlocators.IssueCreationPageLocators;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;

import org.openqa.selenium.support.ui.Select;
import com.taf.core.TestContext;
import com.taf.core.TestPage;
import java.util.List;
import org.openqa.selenium.WebElement;

public class IssueCreationPage extends TestPage {
    TestContext appiumContext;
    IssueCreationPageLocators issueCreationPageLocators;
    String warnignMessage = "";

    public IssueCreationPage(TestContext context) {
        super(context);
        if (context.getClass().getSimpleName().contains("AndroidContext"))
            appiumContext = (AppiumAndroidContext) context;
    }

    public void initializeElementProvider() {
    	issueCreationPageLocators = new IssueCreationPageLocators(appiumContext);
    }

       
    public void enterCreateIssueDetails(String title, String description, String impact) {
      appiumContext.enterTextIn(issueCreationPageLocators.getTitleId(), title);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.enterTextIn(issueCreationPageLocators.getDescriptionId(), description);
      appiumContext.waitFor(2000);
      appiumContext.hideKeyBoard();
      appiumContext.enterTextIn(issueCreationPageLocators.getImpactId(), impact);
      appiumContext.hideKeyBoard();
      appiumContext.waitFor(2000);
      
      
      appiumContext.click(issueCreationPageLocators.getIdentifiedDateId());
      int indentfiedDate = CommonFunctions.getTodaysDate() - 2;    
	  String DateXpath = CommonFunctions.setDate(indentfiedDate);
	  appiumContext.click(issueCreationPageLocators.getCalanderDateId(DateXpath));	  
	  appiumContext.waitFor(2000);
	  
	  appiumContext.click(issueCreationPageLocators.getDueDateId());
	  String DateXpath1 = CommonFunctions.setDate(1);
	  appiumContext.click(issueCreationPageLocators.getCalanderDateId(DateXpath1));	
	  appiumContext.waitFor(2000);
	  
      setAssignedOwner();
      appiumContext.waitFor(2000);
      setSeverity();
      appiumContext.waitFor(2000);
      setMilestone();
      appiumContext.waitFor(2000);
      appiumContext.click(issueCreationPageLocators.getSubmitButtonId());
  }
    
    public void selectByText(WebElement element, String text) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(text);
	}
    
    public void setAssignedOwner()
    {  	
    	if(issueCreationPageLocators.getListOfAssignedOwner().size() > 0) {		
			List<WebElement> assignedOwnerList = issueCreationPageLocators.getListOfAssignedOwner();	
			selectByText((WebElement) issueCreationPageLocators.getAssignedOwnerId(), assignedOwnerList.get(2).getText());
		}
    }
    
    public void setMilestone()
	{
		if(issueCreationPageLocators.getListOfMilestone().size() > 0) {		
			List<WebElement> milestoneList = issueCreationPageLocators.getListOfMilestone();			
			selectByText((WebElement) issueCreationPageLocators.getMilestoneId(), milestoneList.get(2).getText());
		}
	} 
    
    public void setSeverity()
    {  	
    	if(issueCreationPageLocators.getListOfSeverity().size() > 0) {		
			List<WebElement> severityList = issueCreationPageLocators.getListOfSeverity();	
			selectByText((WebElement) issueCreationPageLocators.getSeverityId(), severityList.get(2).getText());
		}
    }
}