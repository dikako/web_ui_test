package config;

import org.openqa.selenium.WebDriver;

public class Url {
	private WebDriver driver;

//	 String baseUrl = "https://rc-webm.rctiplus.com";

	String baseUrl = "https://rctiplus.com";

	public Url(WebDriver driver) {
		this.driver = driver;
	}

	public void defaultUrl() {
		driver.get(baseUrl);
		System.out.println("Url Visit: " + driver.getCurrentUrl());
	}

	public void urls(String page) {
		String urlPage = baseUrl + page.toLowerCase().replace(" ", "");
		driver.get(urlPage);
		assert driver.getCurrentUrl().contains(page.toLowerCase().replace(" ", ""));
		System.out.println("Url Visit: " + driver.getCurrentUrl());
	}
}
