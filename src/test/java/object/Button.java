package object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Button {
	WebDriver driver;

	public Button(WebDriver driver) {
		this.driver = driver;
	}

	public void byId(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}
	
	//aaaa
	public void byXpaths(String selector) {
		WebElement element = driver.findElement(By.xpath(selector));
		element.click();
		System.out.println("Button is Clicked!");
	}
	//aaaa

	public void byXpath(String selector) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}
	
	public void byLinkText(String selector) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byClass(String selector) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byCss(String selector) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byTag(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byIdGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byXpathGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byClassGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byTagGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byCssGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byNameGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	public void byLinkTextGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""),
				buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}

	// Button Display

	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button is Displayed");
	}

	public void byClassDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button is Displayed");
	}
	
	public void byClassNotNull(String selector) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertNotNull(element.size());
		System.out.println("Element is Found");
	}
	
	public void byClassNull(String selector) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertNull(element.size());
		System.out.println("Element is Found");
	}
	
	public void byIdNotNull(String selector) {
		List<WebElement> element = driver.findElements(By.id(selector));
		Assert.assertNotNull(element.size());
		System.out.println("Element is Found");
	}
	
	public void byClassDisplay(String selector) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertTrue(element.isDisplayed());
		actions.build().perform();
		System.out.println("Button is Displayed");
	}

	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed");
	}

	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed");
	}

	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed");
	}

	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed");
	}

	// Klik By Index

	public void byIdByIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.id(selector));
		System.out.println(element.size());
		element.get(index).click();
		System.out.println("Button Is Clicked");
	}

	public void byClassByIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.className(selector));
		System.out.println(element.size());
		element.get(index).click();
		System.out.println("Button is Clicked!");
	}
	
	public void byXpathByIndex(String selector, int index) {
		List<WebElement> element = driver.findElements(By.xpath(selector));
		System.out.println(element.size());
		element.get(index).click();
		System.out.println("Button is Clicked!");
	}

	// Get Attributes

	public void byClassByTagByAttrToString(String selector, int index, String tagName, String attr,
			String attributeValue) {
		List<WebElement> element = driver.findElements(By.className(selector));
		String element2 = element.get(index).findElement(By.tagName(tagName)).getAttribute(attr).toString();
		System.out.println("Attribute Value is Match!" + " " + element2);
		Assert.assertEquals(element2, attributeValue);
	}
	
	//Get Attribute
	public void byClassByTagByAttrToStrings(String selector, String tagName, String attr,
			String attributeValue) {
		WebElement element = driver.findElement(By.className(selector));
		String element2 = element.findElement(By.tagName(tagName)).getAttribute(attr).toString();
		System.out.println("Attribute Value is Match!" + " " + element2);
		assert element2.contains(attributeValue);
	}
	

	// Get text By index

	public void byClassesGetText(String selector, int index, String textValue) {
		List<WebElement> element = driver.findElements(By.className(selector));
		String getText = element.get(index).getText();
		System.out.println("Value is Match " + getText);
		Assert.assertEquals(getText.toLowerCase().replace(" ", ""), textValue.toLowerCase().replace(" ", ""));
	}
	
	// Get Size 
	public void byClassGetSize(String selector, int size) {
		List<WebElement> element = driver.findElements(By.className(selector));
		Assert.assertEquals(element.size(), size);
		System.out.println("Size is Match! " + element.size());
	}
	
	// Get Size cuma
	public void byClassGetSized(String selector) {
		List<WebElement> element = driver.findElements(By.className(selector));
		element.size();
		System.out.println("Size is Match! " + element.size());
	}
	
	//Valdiate Button disbld 0r enabled
	
	public void byIdEnabled(String selector, boolean enable) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		boolean btn = element.isEnabled();
		Assert.assertEquals(btn, enable);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		System.out.println("Button is Enabled: " + btn);
	}
	
	public int byClassReturnSize(String selector) {
		List<WebElement> element = driver.findElements(By.className(selector));
		return element.size();
	}

	// boolean display function
	public Boolean isClassDisplay(String selector) {
		return driver.findElements(By.className(selector)).size() > 0;		
	}
	
	public Boolean isXpathDisplay(String selector) {
		return driver.findElements(By.xpath(selector)).size() > 0;		
	}
	
	// boolean null
	public Boolean isClassNotDisplay(String selector) {
		return driver.findElements(By.className(selector)).size() == 0;		
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
