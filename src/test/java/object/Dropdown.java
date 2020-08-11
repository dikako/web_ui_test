package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
	WebDriver driver;
	
	public Dropdown(WebDriver driver) {
		this.driver = driver;
	}
	
	// By Value
	
	public void dropdownByIdByValue(String selector, String value) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + value);
	}
	
	public void dropdownByXpathByValue(String selector, String value) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + value);
	}
	
	public void dropdownByCssByValue(String selector, String value) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + value);
	}
	
	public void dropdownByNameByValue(String selector, String value) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + value);
	}
	
	public void dropdownByClassByValue(String selector, String value) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + value);
	}
	
	// By Index
	
	public void dropdownByIdByIndex(String selector, int index) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + index);
	}
	
	public void dropdownByXpathByIndex(String selector,int index) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + index);
	}
	
	public void dropdownByCssByIndex(String selector, int index) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + index);
	}
	
	public void dropdownByNameByIndex(String selector, int index) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + index);
	}
	
	public void dropdownByClassByIndex(String selector, int index) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + index);
	}
	
	// By Visible Text
	
	public void dropdownByIdByVisibleText(String selector, String text) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + text);
	}
	
	public void dropdownByXpathByVisibleText(String selector,String text) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + text);
	}
	
	public void dropdownByCssByVisibleText(String selector, String text) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + text);
	}
	
	public void dropdownByNameByVisibleText(String selector, String text) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + text);
	}
	
	public void dropdownByClassByVisibleText(String selector, String text) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		actions.build().perform();
		System.out.println("Dropdown Selected: " + text);
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
