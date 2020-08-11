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

public class Test_Edit_Profile extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] edit_profile() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Edit_Profile_Input");
	}
	
	@DataProvider
	public String[][] edit_profile_alert_form_field() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Edit_Profile_Alert_Named");
	}
	
	@DataProvider
	public String[][] edit_profile_alert_Phone() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Edit_Profile_Alert_Phone");
	}
	
	@DataProvider
	public String[][] edit_profile_validate_button() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Edit_Profile_Validate_Button");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Edit Profile Test - Success Edit Profile")
	@Test(priority = 0, testName = "Edit Profile Test - Success Edit Profile", dataProvider = "edit_profile")
	public void edit_profile_success_edit_fullname(String username, String password, String edit, String inputEdit)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Edit Profile Test - Success Edit Profile");

		// Action Login
		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		button.byId("action-profile");
		Thread.sleep(5000);
		button.byId(edit + "-input");
		Thread.sleep(5000);
		input.byId("form-field", inputEdit);
		button.byId("save-edit");
		Thread.sleep(5000);
		
		input.byIdAttr(edit + "-input", "value", inputEdit);

		// Back Change
		button.byId(edit + "-input");
		input.byId("form-field", "notEdit");
		button.byId("save-edit");
		System.out.println("Fullname kembali kesemula");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Edit Profile Test - Alert Edit Profile Form Field")
	@Test(priority = 1, testName = "Edit Profile Test - Alert Edit Profile Form Field", dataProvider = "edit_profile_alert_form_field")
	public void edit_profile_form_field_alert(String username, String password, String edit, String inputEdit, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Edit Profile Test - Alert Edit Profile Form Field");

		// Action Login
		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId(edit + "-input");
		Thread.sleep(5000);
		
		input.byId("form-field", inputEdit);
		button.byId("save-edit");
		alert.byIdByTag("invalid-feedback-top", "p", alertText);
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Edit Profile Test - Alert Edit Profile Phone Alert")
	@Test(priority = 2, testName = "Edit Profile Test - Alert Edit Profile Phone Alert", dataProvider = "edit_profile_alert_Phone")
	public void edit_profile_phone_alert(String username, String password, String edit, String inputEdit, String alertText)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Edit Profile Test - Alert Edit Profile Phone Alert");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-profile");
		Thread.sleep(5000);
		
		button.byId(edit + "-input");
		Thread.sleep(5000);
		
		input.byId("phone_number", inputEdit);
		button.byId("save-edit");
		alert.byIdByTag("invalid-feedback-top", "p", alertText);
	}
}
