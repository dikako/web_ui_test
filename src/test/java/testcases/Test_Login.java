package testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Test_Login extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] login_success() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Success");
	}

	@DataProvider
	public String[][] login_alert_username() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Username");
	}

	@DataProvider
	public String[][] login_alert_password() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Password");
	}

	@DataProvider
	public String[][] login_alert_popup() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Popup");
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Login Alert Pop Up Not Registered")
	@Test(priority = 0, testName = "Login Alert Pop Up", dataProvider = "login_alert_popup")
	public void login_alert_popup(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);

		System.out.println("Login Test - Login Alert Pop Up Not Registered");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		alerts.byId("swal2-content", alertText);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Login Logout")
	@Test(priority = 1, testName = "Login Logout", dataProvider = "login_success")
	public void login_logout(String username, String password, String displayName) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test - Login Logout");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);

		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Login Alert Password")
	@Test(priority = 2, testName = "Login Alert Password", dataProvider = "login_alert_password")
	public void login_alert_password(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);

		System.out.println("Login Test - Login Alert Password");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		alerts.byId("invalid-password", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Login Alert Username")
	@Test(priority = 3, testName = "Login Alert Username", dataProvider = "login_alert_username")
	public void login_alert_username(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);

		System.out.println("Login Test - Login Alert Username");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		alerts.byId("invalid-username", alertText);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Login Success")
	@Test(priority = 4, testName = "Login Success", dataProvider = "login_success")
	public void login_succes(String username, String password, String displayName) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test - Login Success");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test Integration - Login Success From Account -> Login")
	@Test(priority = 5, testName = "Login Success From Account -> Login", dataProvider = "login_success")
	public void login_logout_from_account(String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Login");

		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("button-login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		button.byIdDisplay("button-login", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test Integration - Login Success From Account -> History")
	@Test(priority = 6, testName = "Login Success Account -> History", dataProvider = "login_success")
	public void login_logout_from_history(String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> History");

		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-history");
		Thread.sleep(5000);
		
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);

		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test Integration - Login Success From Account -> Mylist")
	@Test(priority = 7, testName = "Login Success Account -> Mylist", dataProvider = "login_success")
	public void login_logout_from_mylist(String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Mylist");

		url.defaultUrl();
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-mylist");
		Thread.sleep(5000);
		
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);

		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test Integration - Login Success From Account -> Continue Watching")
	@Test(priority = 8, testName = "Login Success Account -> Continue Watching", dataProvider = "login_success")
	public void login_logout_from_Continue_Watching(String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Continue Watching");

		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-continue-watching");
		Thread.sleep(5000);
		
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);

		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}
}
