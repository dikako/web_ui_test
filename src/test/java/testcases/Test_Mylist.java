package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class Test_Mylist extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] mylist() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Mylist");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Mylis Test - After Login From Library")
	@Test(priority = 0, testName = "Mylis Test - After Login From Library", dataProvider = "mylist")
	public void mylist_after_login_library(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Mylis Test - After Login From Library");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		url.urls("/explores");
		button.byClassByIndex("col-4", 1);
		String getTitleBeforeAddMylist = alert.byClassGetText("content-title");
		System.out.println(getTitleBeforeAddMylist);
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);

		url.urls("/profile");		
		button.byId("action-mylist");
		Thread.sleep(5000);
		
		button.byXpath("//strong[contains(text(),'" + getTitleBeforeAddMylist + "')]");
		Thread.sleep(5000);
		
		String getTitleAfterAddMylist = alert.byClassGetText("content-title");
		Assert.assertEquals(getTitleBeforeAddMylist, getTitleAfterAddMylist);
		System.out.println(getTitleAfterAddMylist);

		// un Mylist
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);
		System.out.println("Un MyLIST");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Mylis Test Integration - After Login From Library")
	@Test(priority = 1, testName = "Mylis Test Integration - After Login From Library", dataProvider = "mylist")
	public void integration_mylist_after_login_library(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Mylis Test Integration - After Login From Library");

		url.defaultUrl();
		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("button-login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-library");
		Thread.sleep(5000);
		
		button.byClassByIndex("col-4", 1);
		Thread.sleep(5000);

		String getTitleBeforeAddMylist = alert.byClassGetText("content-title");
		System.out.println(getTitleBeforeAddMylist);
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);

		button.byId("action-account");
		Thread.sleep(5000);
		
		button.byId("action-mylist");
		Thread.sleep(5000);
		
		button.byXpath("//strong[contains(text(),'" + getTitleBeforeAddMylist + "')]");
		Thread.sleep(5000);
		
		String getTitleAfterAddMylist = alert.byClassGetText("content-title");
		Assert.assertEquals(getTitleBeforeAddMylist, getTitleAfterAddMylist);
		System.out.println(getTitleAfterAddMylist);

		// un Mylist
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);
		System.out.println("Un MyLIST");
	}
}
