package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
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

public class Test_Login_Phone_Code extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] login_phone_code() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Phone_Code");
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Login Test Phone Code")
	@Test(priority = 0, testName = "Login Test Phone Code", dataProvider = "login_phone_code")
	public void login(String username, String password, String country, String alertText, String countryName) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Login Test Phone Code");

		url.urls("/login");
		input.byId("email", username);
		button.byId("action-country-code");
		button.byClass("search-action");
		
		input.byId("search", country + Keys.ENTER);
		button.byClassByIndex("country-item", 0);
		alerts.byId("action-country-code", countryName);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-account");
		alerts.byId("action-profile", alertText);
	}
}
