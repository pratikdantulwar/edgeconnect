package com.edgeconnect.automation.utils;

import java.awt.List;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonFunctions {
    public static String getRandomString() {
        return RandomStringUtils.random(8, true, false);
    }
    
    
    /**
	 * Random number generation
	 * @return
	 */
	public static int getRandomNumber()
	{
		Random random = new Random(); 
		return random.nextInt(1000);
	}
    
	/**
	 * Setting the date - picking the value from date picker
	 * @param dateValue
	 * @return 
	 */
    public static String setDate(int dateValue)
	{
		String DateXpath = "(//div[@class='btn-light'])[" + dateValue +  "]";
		
		return DateXpath;
	}
        
    /**
	 * Getting todays date
	 * @return date
	 */
	public static int getTodaysDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		return Integer.parseInt(dtf.format(localDate).toString().substring(0, 2));
	}
	
	/**
	 * Getting the root directory path of the project
	 * @return
	 */
	public static String getRootDirectoyPath()
	{
		File currentDirFile = new File(".");
		//getting the path for current directory
		String path = currentDirFile.getAbsolutePath();
		//removing the "." from the directory path
		path = path.substring(0, path.length()-1);	
		
		return path;		
	}
	
	/**
	 * Retrieving the data for login
	 * @param testCaseName name of the test case
	 * @return
	 * @throws Exception
	 */
	public static int getRowNumberForLoginData(String testCaseName) throws Exception
	{
		String sTestCaseName = ExcelUtils.getTestCaseName(testCaseName);		
		//log.info("statring test case name : " + sTestCaseName);		
		ExcelUtils.setExcelFile(Constant.PATH_TESTDATA + Constant.FILE_TESTDATA,"data");
		int iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.COL_TESTCASENAME);		
		return iTestCaseRow;
	}
	
	/**
	 * Getting the data from excel
	 * @param testCaseName
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, String> getData(String testCaseName) throws Exception
	{
//		ArrayList<InputData> employees = new ArrayList<InputData>();
//		employees.get(1).setissueDescription("he");
//		employees.get(2).setissueDescription("ok");
//		System.out.println(employees.get(1).getissueDescription());
//		System.out.println(employees.get(2).getissueDescription());
		
		int iTestCaseRow;	  	    
		iTestCaseRow = CommonFunctions.getRowNumberForLoginData(testCaseName); 
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("userName",  ExcelUtils.getCellData(iTestCaseRow, Constant.COL_USRNAME));
		testData.put("password",  ExcelUtils.getCellData(iTestCaseRow, Constant.COL_PASSWORD));
		testData.put("description",  ExcelUtils.getCellData(iTestCaseRow, Constant.COL_DESCRIPTION));
		testData.put("impact",  ExcelUtils.getCellData(iTestCaseRow, Constant.COL_IMPACT));
		
		return testData;
		
	}
}


