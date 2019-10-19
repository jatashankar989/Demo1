package Practical;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.loginHomePage;
import resources.base;

public class testingInclusion extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void revokeBrowser() throws IOException {
		driver = initTestPages();
		log.info("Initialising of Driver is Successfuly Started");
	}

	@Test
	public void testingCases() {
		driver.get(prop.getProperty("url"));
		log.info("Successfully hitting on the Url ");
		loginHomePage hp = new loginHomePage(driver);
		log.info("Reached on HomePage successfully");
		//hp.signIn().click();
		//log.info("Succesfully hitting on the Login Button");
		Assert.assertEquals(hp.text().getText(), "FEATURED COU!RSES");
	}

	@AfterTest
	public void Shrinkbrowser() {
		driver.close();
		log.info("Successfully closing the browser");
	}

}
