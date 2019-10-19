package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class emailSecondaryPage {

	public WebDriver driver;

	By pName = By.xpath("//input[@id='user_email']");
	By pSwd = By.xpath("//input[@id='user_password']");
	By bTTn = By.xpath("//input[@name='commit']");

	public WebElement pName() {
		return driver.findElement(pName);
	}

	public WebElement pSwd() {
		return driver.findElement(pSwd);
	}

	public WebElement bTTn() {
		return driver.findElement(bTTn);
	}
	public emailSecondaryPage(WebDriver driver)
	{
		this.driver=driver;
	}
}
