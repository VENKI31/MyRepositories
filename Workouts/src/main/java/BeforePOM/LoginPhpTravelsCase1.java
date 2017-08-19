package BeforePOM;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPhpTravelsCase1 
{
	public static void main(String[] args) 
	{
		short cnt=0;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver64.exe");
		//System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe");			
		ChromeDriver driver = new ChromeDriver();
		//InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://phptravels.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[contains(text(),'Login')]").click();
		Set<String> allWinds = driver.getWindowHandles();
		cnt=(short) allWinds.size();
		for (String oneWind : allWinds) {
			driver.switchTo().window(oneWind);
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("Secondary_Navbar-Account")));
		driver.findElementById("Secondary_Navbar-Account").click();		
		Actions moveAction = new Actions(driver);
		//driver.findElementByLinkText("Register").click();
		//moveAction.moveToElement(driver.findElementByLinkText("Register")).build().perform();
		moveAction.click(driver.findElementByLinkText("Register")).build().perform();

		//To close multiple windows starting from recently open
		while(allWinds.size()>0)  {
			for (String oneWind : allWinds) {
				driver.switchTo().window(oneWind);
			}
			driver.close();
			cnt--;
			if(cnt==0)
				break;
			allWinds = driver.getWindowHandles();
		}		
	}
}