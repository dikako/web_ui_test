package object;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Input {
	WebDriver driver;

	public Input(WebDriver driver) {
		this.driver = driver;
	}

	// Input
	public void byId(String selector, String value) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byIdNotClear(String selector, String value) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	public void byXpath(String selector, String value) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	public void byClass(String selector, String value) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	public void byTag(String selector, String value) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	public void byCss(String selector, String value) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	public void byName(String selector, String value) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		element.clear();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}

	// Display
	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	public void byClassDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}

	// atributte

	public void byIdAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.id(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	public void byXpathAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.xpath(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	public void byCssAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	public void byNameAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.name(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	public void byTagAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.tagName(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	public void byClassAttr(String selector, String attr, String valueAttr) {
		WebElement element = driver.findElement(By.className(selector));
		String attribute = element.getAttribute(attr);
		Assert.assertEquals(attribute, valueAttr);
		System.out.println("Attribute Value: " + valueAttr);
	}
	
	//Validate Input by first index 
	public void validateInputTextByClassByIndexone(String selector, String textChat) {
		List<WebElement> element = driver.findElements(By.className(selector));
		int elementSize = element.size() - 1;
		
		for (int i = elementSize; i == elementSize; i++) {
			Assert.assertEquals(element.get(i).getText().toLowerCase().replace(" ", ""), textChat.toLowerCase().replace(" ", ""));		
			System.out.println("Text input & output is match!");
		}
	}
	
	//Clear
	
	public void byIdClear(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		element.clear();
		System.out.println("Form is cleared!");
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
