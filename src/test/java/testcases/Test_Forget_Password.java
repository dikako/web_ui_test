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

public class Test_Forget_Password extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] forget_password_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Forget_Password_Alert");
	}

	@Severity(SeverityLevel.MINOR)
	@Description("Forget Password - Alert Username")
	@Test(priority = 0, testName = "Forget Password - Alert Username", dataProvider = "forget_password_alert")
	public void forget_password_alert(String username, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Forget Password - Alert Username");

		url.urls("/forget-password");
		input.byId("input-email-phone", username);
		button.byId("button-next");
		alert.byId("invalid-feedback", alertText);
	}
}
