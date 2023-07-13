package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScreen {
	WebDriver driver;
	
	public HomeScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	static By weatherDataLink = By.xpath("//div[@id='navbarNav']//a[contains(text(),'Weather Data')]");
	static By modalContent = By.xpath("//div[contains(@class,'modal-lg')]//div[@class='modal-content']");
	static By modalContentButton = By.xpath("//button[contains(text(),'Accept all cookies')]");
	static By homeScreenTitle = By.xpath("//span[contains(text(),'Weather Data & API')]");
	
	
	public WebElement weatherDataLink() {
		 return driver.findElement(weatherDataLink);
	}
	
	public static By modalContent() {
		return modalContent;
	}
	
	public static By modalContentButton() {
		return modalContentButton;
	}
	
	public WebElement homeScreenTitle() {
		return driver.findElement(homeScreenTitle);
	}
	

}
