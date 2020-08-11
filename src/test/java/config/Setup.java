package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.TakeScreenshot;

public class Setup {
	protected RemoteWebDriver driver;

	@BeforeMethod
	public void set() throws MalformedURLException {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Galaxy S5");
		ChromeOptions handlessOptions = new ChromeOptions();
		handlessOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		handlessOptions.addArguments("enable-automation");
		handlessOptions.addArguments("--no-sandbox");
		handlessOptions.addArguments("--disable-infobars");
		handlessOptions.addArguments("--disable-dev-shm-usage");
		handlessOptions.addArguments("--disable-browser-side-navigation");
		handlessOptions.addArguments("--disable-gpu");
		handlessOptions.addArguments("--disable-popup-blocking");
		URL url = new URL("http://172.31.0.70:4444/wd/hub");
//		 URL url = new URL("http://localhost:4444/wd/hub");
//		 URL url = new URL("http://selenium.mncplus.com/wd/hub");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, handlessOptions);
		handlessOptions.merge(capabilities);
		driver = new RemoteWebDriver(url, handlessOptions);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().logs();
	}

	@AfterMethod
	public void done(ITestResult result) throws InterruptedException {
		String name = result.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			TakeScreenshot.captureScreenshot(driver, "Error_" + name);
			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed!");
			System.out.println(result.getMethod().getMethodName() + " failed!");
			driver.quit();
		} else {
			TakeScreenshot.captureScreenshot(driver, "Pass_" + name);
			driver.quit();
		}
	}
}
