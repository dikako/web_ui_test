package testcases;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Button;
import utility.ReadExcel;

public class Test_Live_Tv extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] live_tv_active_tab() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Live_Tv_Active_Tab");
	}

	@DataProvider
	public String[][] tab_livetv_catchup() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Live_Tv_Tab_Live_And_Catch");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Live Tv Test - Validate List Tab Live Tv")
	@Test(priority = 0, testName = "Validate List Tab Live Tv", dataProvider = "live_tv_active_tab")
	public void live_tv_list_tab_livetv(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Live Tv Test - Validate List Tab Live Tv");

		url.defaultUrl();
		button.byId("action-live-tv");
		Thread.sleep(5000);
		button.byClassesGetText("text-center", indexToInt, textValue);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Live Tv Test - Validate Tab Live and Cacthup")
	@Test(priority = 1, testName = "Validate Tab Live and Cacthup", dataProvider = "tab_livetv_catchup")
	public void live_tv_live_and_cathup(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Live Tv Test - Validate Tab Live and Cacthup");

		url.defaultUrl();
		button.byId("action-live-tv");
		Thread.sleep(5000);
		button.byClassesGetText("nav-link", indexToInt, textValue);
	}
}
