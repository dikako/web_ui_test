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

	public String path = "../web_ui_test/src/main/java/data/data_test.xlsx";

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
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		alerts.byId("swal2-content", alertText);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test - Login Logout")
	@Test(priority = 1, testName = "Login Logout", dataProvider = "login_success")
	public void login_logout(String username, String password, String displayName) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Login Test - Login Logout");

		url.urls("/login");
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		button.byXpathGetText("//li[@class='title']", displayName);

		button.byXpath("//a[@class='btn btn-dark']");
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		alert.urlValidate("/login");
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
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		alerts.byXpath("//small[@class='text-danger fixed']", alertText);
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
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		alerts.byXpath("//small[@class='text-danger']", alertText);
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
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		button.byXpathGetText("//li[@class='title']", displayName);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Login Test Integration - Login Success From Account -> Login")
	@Test(priority = 5, testName = "Login Success From Account -> Login", dataProvider = "login_success")
	public void login_logout_from_account(String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Login Test Integration - Login Success From Account -> Login");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		button.byId("button-login");
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		button.byXpathGetText("//li[@class='title']", displayName);

		button.byXpath("//a[@class='btn btn-dark']");
		Thread.sleep(5000);

		button.byXpath("//i[@class='fas fa-bars']");
		Thread.sleep(5000);

		alert.urlValidate("/login");
	}
}
