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

public class Test_Homepage extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] homepage_menu_tengah() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Homepage_Menu_Tengah");
	}

	@DataProvider
	public String[][] homepage_menu_bawah() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Homepage_Menu_Bawah");
	}

	@DataProvider
	public String[][] homepage_menu_bawah_direct() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Homepage_Menu_Bawah_Direct");
	}

	@DataProvider
	public String[][] homepage_menu_tengah_direct() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Homepage_Menu_Tengah_Direct");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Search Direct")
	@Test(priority = 0, testName = "Hompage Test - Search Direct")
	public void homepage_search_direct() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Hompage Test - Search Direct");

		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byClass("search-input");
		Thread.sleep(5000);
		
		alert.urlValidate("explores");
		Thread.sleep(5000);
		
		button.byClassDisplay("swiper-slide", true);
		button.byClassDisplay("col-4", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Story is Found")
	@Test(priority = 1, testName = "Hompage Test - Validate Story is Found")
	public void homepage_story() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Hompage Test - Validate STORY IS FOUND");

		url.defaultUrl();
		button.byClassDisplay("story", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Slider is Found")
	@Test(priority = 2, testName = "Hompage Test - Validate Slider is Found")
	public void homepage_slider() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Hompage Test - Validate Slider Is Found");

		url.defaultUrl();
		button.byClassDisplay("slide", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Center Menu")
	@Test(priority = 3, testName = "Hompage Test - validate Center Menu", dataProvider = "homepage_menu_tengah")
	public void homepage_center_menu(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Hompage Test - validate Center Menu");

		url.defaultUrl();
		button.byClassesGetText("menu-item", indexToInt, textValue);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Footer Menu")
	@Test(priority = 4, testName = "Hompage Test - validate Footer Menu", dataProvider = "homepage_menu_bawah")
	public void homepage_footer_menu(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Hompage Test - validate Footer Menu");

		url.defaultUrl();
		button.byClassesGetText("footer-wrapper-list", indexToInt, textValue);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Footer Menu Direct Url")
	@Test(priority = 5, testName = "Hompage Test - validate Footer Menu Direct Url", dataProvider = "homepage_menu_bawah_direct")
	public void homepage_footer_menu_direct(String index, String textValue, String urls) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Hompage Test - validate Footer Menu Direct Url");

		url.defaultUrl();
		button.byClassesGetText("footer-wrapper-list", indexToInt, textValue);
		button.byClassByIndex("footer-wrapper-list", indexToInt);
		Thread.sleep(5000);
		
		alert.urlValidate(urls);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Homepage Test - validate Center Menu Direct Url")
	@Test(priority = 6, testName = "Hompage Test - validate Center Menu Direct Url", dataProvider = "homepage_menu_tengah_direct")
	public void homepage_center_menu_direct(String index, String textValue, String urls) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Hompage Test - validate Center Menu Direct Url");

		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byClassesGetText("menu-item", indexToInt, textValue);
		button.byClassByIndex("menu-item", indexToInt);
		Thread.sleep(5000);
		
		alert.urlValidate(urls);
	}
}
