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
import object.Alert;
import object.Button;
import utility.ReadExcel;

public class Test_Live_Event extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] list_tab_live_event() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Tab_Live_Event");
	}

	@Description("Live Event Test - Dashboard Live Event")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Live Event Test - Dashboard Live Event", dataProvider = "list_tab_live_event")
	public void live_event(String index, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Live Event - Dashboard Live Event");

		url.defaultUrl();
		button.byId("action-live-event");
		alert.byClassByIndex(indexToInt, "le-title", alertText);
		button.byClassDisplay("thumb-img", true);
	}

	@Description("Live Event Test - List Tab On Player Live Event ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, testName = "Live Event Test - List Tab On Player Live Event", dataProvider = "list_tab_live_event")
	public void live_event_klik_live_event(String index, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Live Event - List Tab On Player Live Event");

		url.defaultUrl();
		button.byId("action-live-event");
		if (button.isClassDisplay("thumb-timer")) {
			button.byClassByIndex("thumb-timer", 0);
			alert.byClassByIndex(indexToInt, "nav-link", alertText);
		} else {
			System.out.println("Data Live Event Tidak Ada");
		}
	}
}
