package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Button;

public class Test_Sticky_Ads_Homepage extends Setup {
	
	@Description("Sticky Ads Test - Under Story")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Sticky Ads Test - Under Story")
	public void sticky_ads() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		
		System.out.println("Sticky Ads Test - Validate Display Under Story");
		
		url.defaultUrl();
		button.byIdNotNull("google_image_div");
	}
	
	@Description("Sticky Ads Test - Scroll Button")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, testName = "Sticky Ads Test - Scroll Button")
	public void sticky_ads_Scroll_Buttom() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		System.out.println("Sticky Ads Test - Validate Display Scroll Button");
		
		url.defaultUrl();
		js.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(5000);
		button.byIdNotNull("google_image_div");
		button.byClassNotNull("ads-close-btn");
	}
}
