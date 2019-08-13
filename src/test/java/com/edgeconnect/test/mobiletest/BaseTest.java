/**
 *
 */
package com.edgeconnect.test.mobiletest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edgeconnect.automation.utils.CommonFunctions;
import com.edgeconnect.automation.utils.ConfigReader;
import com.edgeconnect.automation.utils.DeleteSnapshot;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidEngine;
import com.edgeconnect.taf.impl.appiumandroid.models.AppiumAndroidCapabilities;
import com.reporter.reportengine.Report;
import com.reporter.reportengine.ReportEngine;
import com.reporter.reportengine.core.Reporter;
import com.taf.core.TestApplication;

/**
 * @author surendrane
 */
public class BaseTest {

    public Reporter reporter;
    TestApplication testApp;
    protected AppiumAndroidEngine appiumAndroidEngine;
    protected AppiumAndroidCapabilities appiumAndroidCapabilities;
    public Properties configData = ConfigReader.getConfData();

    @BeforeTest
    public void setUpReport() {
       DeleteSnapshot.deleteSnapShotDir(); 
       reporter = ReportEngine.initializeReporter(Report.EXTENT_REPORT, "Mobile Report");
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws MalformedURLException {

        if (configData.getProperty("platformName").equalsIgnoreCase("Android")) {
            appiumAndroidEngine = new AppiumAndroidEngine();
            appiumAndroidCapabilities = new AppiumAndroidCapabilities();
            appiumAndroidCapabilities.setAppActivity(configData.getProperty("appActivity"));
            appiumAndroidCapabilities.setAppPackage(configData.getProperty("appPackage"));
            appiumAndroidCapabilities.setUdid(configData.getProperty("udid"));
            appiumAndroidCapabilities.setDeviceName(configData.getProperty("deviceName"));                      
            appiumAndroidEngine.setAndroidCapabilities(appiumAndroidCapabilities);

            File app = new File(configData.getProperty("apkPath"));
            testApp = appiumAndroidEngine.start(app.getAbsolutePath());     
            
        }  else if (configData.getProperty("platformName").equalsIgnoreCase("AndroidBrowser")) {
            appiumAndroidEngine = new AppiumAndroidEngine();
            appiumAndroidCapabilities = new AppiumAndroidCapabilities();
            appiumAndroidCapabilities.setUdid(configData.getProperty("udid"));
            appiumAndroidCapabilities.setDeviceName(configData.getProperty("deviceName"));           
            appiumAndroidCapabilities.setBrowserName(configData.getProperty("browserName"));
            appiumAndroidCapabilities.setAppURL(configData.getProperty("appURL"));            
            appiumAndroidEngine.setAndroidCapabilities(appiumAndroidCapabilities);
            testApp = appiumAndroidEngine.start();          
        }        
               
       reporter.createNewAndAssignTest(method.getName());
       reporter.logInfo("Description : " + method.getAnnotation(Test.class).description());
       reporter.logPass("App Launched Successfully.....");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
    	     
    	if (iTestResult.getStatus() == ITestResult.FAILURE) {
//    		testApp.getTestContext().takeScreenShot(this.getClass().getSimpleName() + ".png");
//            reporter.takeScreenshot("../snapshot/" + this.getClass().getSimpleName() + ".png");
    		
    //		testApp.getTestContext().takeScreenShot(iTestResult.getTestClass().getRealClass().getSimpleName() + ".png");
//    		
    	//	String filePath = "../sanpshot/" + iTestResult.getMethod().getMethodName() + ".png";
    		//reporter.takeScreenshot("../snapshot/" + iTestResult.getMethod().getMethodName() + ".png");
    		
    		
    		testApp.getTestContext().takeScreenShot(iTestResult.getMethod().getMethodName() + ".png");
    		
    		
    		reporter.takeScreenshot("snapshot/" + iTestResult.getMethod().getMethodName() + ".png");
    		//reporter.takeScreenshot("../snapshot\\" + iTestResult.getMethod().getMethodName() + ".png");
//    		
    	//reporter.takeScreenshot(filePath);
        	
        }
        if (appiumAndroidEngine != null)
            appiumAndroidEngine.stop();     
        
       reporter.endOrCloseTest();
    }
   

    @AfterSuite
    public void afterSuite() {
        reporter.closeReportEngine();
    }
}