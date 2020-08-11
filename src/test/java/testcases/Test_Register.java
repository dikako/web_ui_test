package testcases;

import java.io.IOException;
import java.util.Random;

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
import object.Dropdown;
import object.Input;
import utility.ReadExcel;

public class Test_Register extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] register_email_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Email_Alert");
	}

	@DataProvider
	public String[][] register_phone_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Phone_Alert");
	}

	@DataProvider
	public String[][] register_password1_alert_email() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password1_Alert_Email");
	}

	@DataProvider
	public String[][] register_password2_alert_email() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password2_Alert_Email");
	}

	@DataProvider
	public String[][] register_password1_alert_phone() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password1_Alert_Phone");
	}

	@DataProvider
	public String[][] register_password2_alert_phone() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password2_Alert_Phone");
	}

	@DataProvider
	public String[][] register_list_gender() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_List_Gender");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Register Test - Validate Register Page 2 Fullname")
	@Test(priority = 0, testName = "Register Test - Validate Register Page 2 Fullname")
	public void register_page2_validate_fullname() throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Register Test - Validate Register Page 2 Fullname");

		Random random = new Random();
		int randomInt = random.nextInt(10000);

		url.urls("/register");
		input.byId("email", "auieo" + randomInt + "@gmail.com");
		input.byId("password", "password");
		input.byId("password2", "password");
		button.byId("button-next");
		Thread.sleep(2000);
		input.byIdAttr("fullname", "maxlength", "25");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Register Test - Validate Register Page 2 Birthday")
	@Test(priority = 1, testName = "Register Test - Validate Register Page 2 Birthday")
	public void register_page2_validate_birthday() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		Input input = PageFactory.initElements(driver, Input.class);

		System.out.println("Register Test - Validate Register Page 2 Birthday");

		Random random = new Random();
		int randomInt = random.nextInt(10000);

		url.urls("/register");
		input.byId("email", "auieo" + randomInt + "@gmail.com");
		input.byId("password", "password");
		input.byId("password2", "password");
		button.byId("button-next");
		Thread.sleep(5000);
		button.byId("BirthDate");
		alert.byClassDisplay("datepicker-content", true);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Register Test - Validate Register Page 2 Gender ")
	@Test(priority = 2, testName = "Register Validate Gender", dataProvider = "register_list_gender")
	public void register_page2_validate_gender_Male(String gender) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Dropdown dropdown = PageFactory.initElements(driver, Dropdown.class);

		System.out.println("Register Test - Validate Register Page 2 Gender ");

		Random random = new Random();
		int randomInt = random.nextInt(10000);

		url.urls("/register");
		input.byId("email", "auieo" + randomInt + "@gmail.com");
		input.byId("password", "password");
		input.byId("password2", "password");
		button.byId("button-next");
		Thread.sleep(2000);
		dropdown.dropdownByIdByVisibleText("gender", gender);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Phone Number")
	@Test(priority = 3, testName = "Register Phone Number Alert", dataProvider = "register_phone_alert")
	public void register_alert_phone(String phone, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Phone Number");

		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		Thread.sleep(2000);
		alert.byId("invalid-phone-number", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Phone Password Form 1")
	@Test(priority = 4, testName = "Register Password1 Alert Phone", dataProvider = "register_password1_alert_phone")
	public void register_phone_alert_password1(String phone, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Phone Password Form 1");

		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-num-chars", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Phone Password Form 2")
	@Test(priority = 5, testName = "Register Password 2Alert Phone", dataProvider = "register_password2_alert_phone")
	public void register_phone_alert_password2(String phone, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Phone Password Form 2");

		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-not-match", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Email")
	@Test(priority = 6, testName = "Register Email Alert", dataProvider = "register_email_alert")
	public void register_alert_email(String email, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Email");

		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-email", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Password Form 1")
	@Test(priority = 7, testName = "Register Password1 Alert", dataProvider = "register_password1_alert_email")
	public void register_email_alert_password1(String email, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Password Form 1");

		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-num-chars", alertText);
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Register Test - Alert Password Form 2")
	@Test(priority = 8, testName = "Register Password 2Alert", dataProvider = "register_password2_alert_email")
	public void register_email_alert_password2(String email, String password, String rePassword, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Register Test - Alert Password Form 2");

		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-not-match", alertText);
	}
}
