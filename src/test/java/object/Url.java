package object;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Url {
	WebDriver driver;
	
	public Url(WebDriver driver) {
		this.driver = driver;
	}
	
	public void currentUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
}
