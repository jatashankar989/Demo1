package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginHomePage {
WebDriver driver;

By login = By.linkText("Login");
By text =By.xpath("//div[@class='text-center']/h2");


public loginHomePage(WebDriver driver) {
	this.driver=driver;
}

public WebElement text()
{
	return driver.findElement(text);
}

public WebElement signIn()
{
	return driver.findElement(login);
}

}
