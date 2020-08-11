package testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_List_Menu_Account extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] list_menu_account_popup_login() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Menu_Account_Popup_Login");
	}

	@DataProvider
	public String[][] list_menu_account_direct() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Menu_Account_Direct");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Menu Account Not Login Button Login")
	@Test(priority = 0, testName = "Menu Account Not Login Button Login")
	public void menu_account_not_login_button_login() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);

		System.out.println("Menu Account Test - Button Login Condition Not Login");

		url.urls("/profile");
		Thread.sleep(5000);
		
		button.byIdDisplay("button-login", true);
		button.byId("button-login");
		Thread.sleep(5000);
		
		input.byIdDisplay("email", true);
		input.byIdDisplay("password", true);
		button.byIdDisplay("submit-login", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Menu Account Test - Button Scan QR Code Condition Not Login")
	@Test(priority = 1, testName = "Menu Account Test - Button Scan QR Code Condition Not Login")
	public void menu_account_not_login_button_scan_qrcode() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Menu Account Test - Button Scan QR Code Condition Not Login");

		url.urls("/profile");
		Thread.sleep(5000);
		
		button.byIdDisplay("action-qrcode", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Menu Account Test - Button History Condition Not Login")
	@Test(priority = 2, testName = "Test Validate List Menu Account Popup Login", dataProvider = "list_menu_account_popup_login")
	public void menu_account_not_login_popup_login(String element, String alertPopup1, String alertPopup2) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Menu Account Test - Button History Condition Not Login");

		url.urls("/profile");
		Thread.sleep(5000);
		
		button.byIdDisplay("action-" + element, true);
		button.byId("action-" + element);
		Thread.sleep(5000);
		
		alert.byId("pop-up-action-sign-up", alertPopup1);
		alert.byId("pop-up-action-sign-in", alertPopup2);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Menu Account Test - Button List Menu Account Direct")
	@Test(priority = 3, testName = "Test Menu Account Button menu Direct", dataProvider = "list_menu_account_direct")
	public void menu_account_not_login_button_menu_direct(String element, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Menu Account Test - Button List Menu Account Direct");

		url.urls("/profile");
		Thread.sleep(5000);
		
		button.byIdDisplay("action-" + element, true);
		Thread.sleep(5000);
		
		button.byId("action-" + element);
		Thread.sleep(5000);
		
		alert.byClass("header-nav-verif", alertText);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Menu Account Test - Button Download Condition Not Login")
	@Test(priority = 4, testName = "Menu Account Test - Button Download Condition Not Login")
	public void menu_account_not_login_button_download() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Menu Account Test - Button Download Condition Not Login");

		url.urls("/profile");
		Thread.sleep(5000);
		
		button.byIdDisplay("action-download", true);
		button.byId("action-download");
		Thread.sleep(5000);
		
		button.byIdDisplay("popup-action-openstore", true);
		button.byIdDisplay("popup-action-cancel", true);
	}
}
