package object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Alert {
	WebDriver driver;

	public Alert(WebDriver driver) {
		this.driver = driver;
	}

	public void byId(String selector, String alertText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace(",", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace(",", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byClass(String selector, String alertText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byXpath(String selector, String alertText) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byCss(String selector, String alertText) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void bytagName(String selector, String alertText) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byLinkText(String selector, String alertText) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	public void byName(String selector, String alertText) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	// Display

	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	public void byClassDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Alert is Display");
	}

	// Get Text

	public void byNameGetText(String selector) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}

	public void byIdGetText(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		actions.build().perform();
		System.out.println("Text : " + text);
	}

	public String byClassGetText(String selector) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String text = element.getText();
		return text;
	}

	// By selector, Tagname

	public void byIdByTag(String selector, String tag, String alertText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		String tagnameText = element.findElement(By.tagName(tag)).getText();
		Assert.assertEquals(tagnameText.toLowerCase().replace(" ", "").replace("\n", "").replace(",", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace(",", ""));
		actions.build().perform();
		System.out.println("Text : " + tagnameText);
	}

	// Alert Contains

	public void byClassContains(String selector, String alertText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		element.getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("-", "")
				.contains(alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", "").replace("\n", "")
						.replace("-", ""));
		actions.build().perform();
		System.out.println(element.getText());
	}

	// By Attribute Display

	public void byClassByAttrValidateValueAttr(String selector, String attr, String attrValue) {
		WebElement element = driver.findElement(By.className(selector));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		boolean validateAttr = element.getAttribute(attr).contains(attrValue);
		Assert.assertEquals(validateAttr, true);
		actions.build().perform();
		System.out.println("Attribut: " + validateAttr);
	}

	public void byXpathByAttrValidateValueAttr(String selector, String attr, String attrValue) {
		WebElement element = driver.findElement(By.xpath(selector));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		boolean validateAttr = element.getAttribute(attr).contains(attrValue);
		Assert.assertEquals(validateAttr, true);
		actions.build().perform();
		System.out.println("Attribut: " + validateAttr);
	}

	// validate url

	public void urlValidate(String url) {
		boolean u = driver.getCurrentUrl().contains(url);
		Assert.assertEquals(u, true);
		System.out.println("Url: " + driver.getCurrentUrl());
	}

	// validate Class by index
	public void byClassByIndex(int index, String selector, String alertText) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertEquals(
				element.get(index).getText().toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""),
				alertText.toLowerCase().replace(" ", "").replace("\n", "").replace("\n", ""));
		System.out.println(element.get(index).getText());
	}

	private void waitForVisible(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
