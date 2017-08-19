package BeforePOM;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver64.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.moneycontrol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElementById("keymactb1");
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
			if(col.get(0).getText().contains("Silver")){
				for (int j = 0; j < col.size(); j++) {
					System.out.println(col.get(j).getText());
				}
			}
		}
		driver.navigate().to("http://www.moneycontrol.com/commodity/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
		WebElement commelement=driver.findElementByXPath("//*[@id='Moneycontrol/MC_Commodities/MC_Commodities_HP_300x250_div']/following-sibling::div[3]/div/div[2]");
		List<WebElement> commrows=commelement.findElements(By.tagName("tr"));
		for (int i = 1; i < commrows.size(); i++) {
			List<WebElement> col = commrows.get(i).findElements(By.tagName("td"));
			if(col.get(0).getText().contains("Lead")){
				for (int j = 0; j < col.size(); j++) {
					System.out.println(col.get(j).getText());
				}
			}
		}
		driver.close();
	}
}