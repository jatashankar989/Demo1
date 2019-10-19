package Practical;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.emailSecondaryPage;
import PageObject.loginHomePage;
import resources.base;

public class testingInclusion2 extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
     @BeforeTest
     public void goForBrowser() throws IOException
     {
	    driver=initTestPages();
	    log.info("Initialising the Test Browser in the WebPages");
	    	    
     }
 
 @Test(dataProvider = "providerData")
 public void pageReview(String UserName, String Password)
 {
	 driver.get(prop.getProperty("url"));
	 log.info("Successfully Hitting the URL in the WebPage");
	 loginHomePage lp = new loginHomePage(driver);	 
	 log.info("Successfully Reached the Login Home Page");
	 lp.signIn().click();
	 log.info("Successfully Click the Login Button");
	 
	 emailSecondaryPage sp = new emailSecondaryPage(driver);
	 sp.pName().sendKeys(UserName);
	 log.info("Successfully Entring the Username on the Email Text ");
	 sp.pSwd().sendKeys(Password);
	 log.info("Successfully Entring the Password on the Password Text ");
	 sp.bTTn().click();	 
 }
 
 @DataProvider
 public Object[][] providerData()
 {
	 Object[][] data = new Object[1][2];
	 
	 data[0][0]="rajeshSheldonLeonard";
	 data[0][1]="AmyPennyBernaddate";
	 
	 return data;
 }
 
 @AfterTest
 public void closingBrowser()
 {
	 driver.close();
 }

}
