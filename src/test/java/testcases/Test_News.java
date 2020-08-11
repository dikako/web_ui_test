package testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Button;
import utility.ReadExcel;

public class Test_News extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] default_kanal() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "News_Default_Kanal");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("News Test - validate Default Kanal")
	@Test(priority = 0, testName = "Validate Default Kanal", dataProvider = "default_kanal")
	public void news_validate_default_kanal(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("News Test - validate Default Kanal");

		url.urls("/trending");
		button.byClassGetSize("navigation-tabs-item", 3);
		button.byClassesGetText("navigation-tabs-item", indexToInteger, textValue);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("News Test - validate Add Kanal")
	@Test(priority = 1, testName = "News Test - validate Add Kanal")
	public void news_validate_add_kanal() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("News Test - validate Add Kanal");

		url.urls("/trending");
		button.byClass("add-tab-button");
		button.byClassByIndex("button-container", 0);
		button.byClassGetSize("remove-button", 1);

		List<WebElement> element = driver.findElements(By.className("button-container"));
		int sizeListKanal = element.size();

		for (int i = 2; i <= sizeListKanal; i++) {
			button.byClassByIndex("navigation-tabs-item", 0);
			button.byClassByIndex("button-container", 0);
			button.byClassGetSize("remove-button", i);
		}
	}
}
