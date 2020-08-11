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

public class Test_Exclusive extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] list_share() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Share");
	}

	@DataProvider
	public String[][] list_tab_menu_exclusive() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Tab_Menu_Exclusive");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate Tab Menu")
	@Test(priority = 0, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void integration_exclusive_list_tab_menu_klik(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu");

		url.defaultUrl();
		Thread.sleep(5000);
		button.byId("action-exclusive");
		Thread.sleep(5000);
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
		button.byClassByIndex("exclusive-item", indexToInteger);
		button.byClassByTagByAttrToString("exclusive-item", indexToInteger, "a", "class", "active nav-link");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Exclusive Test - Validate List Tab Menu Klik")
	@Test(priority = 1, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void exclusive_list_tab_menu_klik(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu Klik");

		url.urls("/exclusive");
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
		button.byClassByIndex("exclusive-item", indexToInteger);
		Thread.sleep(5000);
		button.byClassByTagByAttrToString("exclusive-item", indexToInteger, "a", "class", "active nav-link");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Exclusive Test - Validate List Tab Menu")
	@Test(priority = 2, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void exclusive_list_tab_menu(String index, String textValue) {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu");

		url.urls("/exclusive");
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Exclusive Test - Validate Thumbnail")
	@Test(priority = 3, testName = "Exclusive Test - Validate Thumbnail")
	public void exclusive_validate_thumbnail() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Exclusive Test - Validate Thumbnail");

		url.urls("/exclusive");
		button.byClassDisplay("program-thumbnail", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Exclusive Test Integration - Validate Thumbnail ")
	@Test(priority = 4, testName = "Exclusive Test Integration - Validate Thumbnail")
	public void integration_exclusive_validate_thumbnail() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Exclusive Test Integration - Validate Thumbnail ");

		url.defaultUrl();
		button.byId("action-exclusive");
		Thread.sleep(5000);
		button.byClassDisplay("program-thumbnail", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Exclusive Test - Validate List Share")
	@Test(priority = 5, testName = "Validate List Share", dataProvider = "list_share")
	public void exclusive_validate_list_share(String index, String listShare) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Share");

		url.urls("/exclusive");
		button.byClass("program-share-button");
		Thread.sleep(5000);
		button.byClassByTagByAttrToString("sheet-action-button-share", indexToInteger, "div", "aria-label", listShare);
	}
}
