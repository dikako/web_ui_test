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
import object.Input;
import utility.ReadExcel;

public class Test_Phone_Code extends Setup {
	
	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] phone_code_number() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Phone_Code_Number");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Login Validate List Phone Code")
	@Test(priority = 0, testName = "Login List Phone Code", dataProvider = "phone_code_number")
	public void login_list_phone_code(String phone, String index, String countryCode) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		Button button = PageFactory.initElements(driver, Button.class);
		
		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Login Test - List Phone Code");

		url.urls("/login");
		input.byId("email", phone);
		button.byIdDisplay("action-country-code", true);
		button.byId("action-country-code");
		alerts.byClass("search-text", "Select Country");
		button.byClassGetSize("country-item", 231);
		button.byClassByIndex("country-item", indexToInt);
		alerts.byId("action-country-code", countryCode);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Login Validate List Phone Code")
	@Test(priority = 1, testName = "Login List Phone Code", dataProvider = "")
	public void login_list_phone_code_default() throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test - List Phone Code");

		url.urls("/login");
		input.byId("email", "82278843");
		button.byIdDisplay("action-country-code", true);
		alerts.byId("action-country-code", "ID");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Register Validate List Phone Code")
	@Test(priority = 2, testName = "Login List Phone Code", dataProvider = "phone_code_number")
	public void register_list_phone_code_default(String phone, String index, String countryCode) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		Button button = PageFactory.initElements(driver, Button.class);
		
		Integer indexToInt = Integer.valueOf(index);

		System.out.println("Register Test - List Phone Code");

		url.urls("/register");
		
		button.byId("register-phone");
		input.byId("phone_number", phone);
		alerts.byId("action-country-code", "ID");
		button.byIdDisplay("action-country-code", true);
		button.byId("action-country-code");
		alerts.byClass("search-text", "Select Country");
		button.byClassGetSize("country-item", 231);
		button.byClassByIndex("country-item", indexToInt);
		alerts.byId("action-country-code", countryCode);
	}
}
