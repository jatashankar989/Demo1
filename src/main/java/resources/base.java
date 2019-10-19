package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initTestPages() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Jata\\MavenPractical\\src\\main\\java\\resources\\srces.properties");		
		prop.load(fis);		
		//String browserName=prop.getProperty("browser");	
		String browserName=	System.getProperty("browser");	// This line will work in Jenkins...
		if(browserName.contains("chromeheadless"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jata\\Downloads\\chromedriver.exe");		
			ChromeOptions options =new ChromeOptions();   // "C:\\Users\\Jata\\Downloads\\chromedriver.exe"
			driver=new ChromeDriver(options);
			if(browserName.contains("headless"))
			{
			     options.addArguments("headless");
			}
		
		}
		
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jata\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jata\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		System.out.println(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;				
	}
	
	public void getScreenShot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Jata\\test\\ScreenShot1.png"));
	}
	

}
