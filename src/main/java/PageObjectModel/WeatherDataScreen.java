package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherDataScreen {
	WebDriver driver;
	
	public WeatherDataScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	static By searchInputBox = By.xpath("//form[@id='wxdataform']//input[@class='form-control']");
	static By searchButton = By.xpath("//form[@id='wxdataform']//button[contains(text(),'Search')]");
	
	public WebElement searchInputBox() {
		return driver.findElement(searchInputBox);
	}

	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

}
