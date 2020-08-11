package testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import config.Setup;
import config.Url;
import object.Button;
import object.Input;
import utility.ReadExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Test_Chat extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] list_chat() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Chat");
	}

//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Chat Test - Test Chatting Before Login")
//	@Test(priority = 0, testName = "Test Chat > Before Login > Type Chat", dataProvider = "list_chat")
//	public void chat_test_before_login(String urlLiveTv, String username, String password, String nickname,
//			String chatText) throws InterruptedException {
//		Url url = new Url(driver);
//		Button button = PageFactory.initElements(driver, Button.class);
//		Input input = PageFactory.initElements(driver, Input.class);
//
//		System.out.println("Chat Test - Test Chatting Before Login");
//
//		url.urls("/tv/" + urlLiveTv);
//		Thread.sleep(5000);
//
//		button.byIdDisplay("btn-expand", true);
//		button.byId("btn-expand");
//		Thread.sleep(5000);
//
//		button.byId("popup-action-signin");
//		input.byId("email", username);
//		input.byId("password", password);
//		button.byId("submit-login");
//		Thread.sleep(5000);
//
//		url.urls("/tv/" + urlLiveTv);
//		Thread.sleep(5000);
//
//		button.byId("btn-expand");
//		Thread.sleep(5000);
//
//		input.byIdDisplay("chat-input", true);
//		input.byId("chat-input", chatText);
//		button.byXpath("//button[@class='send-button btn btn-secondary']");
//		input.validateInputTextByClassByIndexone("username", nickname);
//		input.validateInputTextByClassByIndexone("message", chatText);
//	}
//
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Chat Test - Test Chatting After Login")
//	@Test(priority = 1, testName = "Test Chat > After Login", dataProvider = "list_chat")
//	public void chat_test_after_login(String urlLiveTv, String username, String password, String nickname,
//			String chatText) throws InterruptedException {
//		Url url = new Url(driver);
//		Button button = PageFactory.initElements(driver, Button.class);
//		Input input = PageFactory.initElements(driver, Input.class);
//
//		System.out.println("Chat Test - Test Chatting After Login");
//
//		url.urls("/login");
//		input.byId("email", username);
//		input.byId("password", password);
//		button.byId("submit-login");
//		Thread.sleep(5000);
//
//		url.urls("/tv/" + urlLiveTv);
//		Thread.sleep(5000);
//
//		button.byId("btn-expand");
//		Thread.sleep(5000);
//
//		input.byIdDisplay("chat-input", true);
//		input.byId("chat-input", chatText);
//		button.byXpath("//button[@class='send-button btn btn-secondary']");
//		input.validateInputTextByClassByIndexone("username", nickname);
//		input.validateInputTextByClassByIndexone("message", chatText);
//	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Chat Test Live Event - Test Chatting After Login")
	@Test(priority = 2, testName = "Test Chat Live Event > After Login", dataProvider = "list_chat")
	public void chat_test_live_event_after_login(String urlLiveTv, String username, String password, String nickname,
			String chatText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);

		System.out.println("Chat Test Live Event - Test Chatting After Login");

		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);

		button.byId("action-live-event");
		Thread.sleep(5000);

		if (button.isXpathDisplay("//section[@class='le-live']//div[@class='row']//div[1]//div[1]//img[1]")) {
			button.byXpath("//section[@class='le-live']//div[@class='row']//div[1]//div[1]//img[1]");
			Thread.sleep(10000);

			button.byIdDisplay("btn-expand", true);
			button.byId("btn-expand");
			Thread.sleep(5000);

			input.byXpath("//textarea[@id='chat-input']", chatText + Keys.ENTER);

			input.validateInputTextByClassByIndexone("username", nickname);
			input.validateInputTextByClassByIndexone("message", chatText);
		} else {
			System.out.println("Data Live Event Tidak Ada");
		}
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Chat Test Live Event - Test Chatting Before Login")
	@Test(priority = 3, testName = "Test Chat Live Event > Before Login > Type Chat", dataProvider = "list_chat")
	public void test_chat_live_event__before_login(String urlLiveTv, String username, String password, String nickname,
			String chatText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);

		System.out.println("Chat Test Live Event - Test Chatting Before Login");

		url.defaultUrl();
		button.byId("action-live-event");
		Thread.sleep(5000);

		if (button.isXpathDisplay("//section[@class='le-live']//div[@class='row']//div[1]//div[1]//img[1]")) {
			button.byXpath("//section[@class='le-live']//div[@class='row']//div[1]//div[1]//img[1]");
			Thread.sleep(10000);

			button.byId("btn-expand");
			Thread.sleep(5000);

			button.byId("popup-action-signin");
			input.byId("email", username);
			input.byId("password", password);
			button.byId("submit-login");
			Thread.sleep(10000);

			button.byId("action-live-event");
			Thread.sleep(5000);
			button.byXpath("//section[@class='le-live']//div[@class='row']//div[1]//div[1]//img[1]");
			Thread.sleep(5000);
			button.byId("btn-expand");
			Thread.sleep(5000);
			input.byXpath("//textarea[@id='chat-input']", chatText + Keys.ENTER);
			
			input.validateInputTextByClassByIndexone("username", nickname);
			input.validateInputTextByClassByIndexone("message", chatText);

		} else {
			System.out.println("Data Live Event Tidak Ada");
		}
	}
}
