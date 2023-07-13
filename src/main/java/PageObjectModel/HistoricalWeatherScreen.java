package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HistoricalWeatherScreen {
	
	WebDriver driver;
	
	public HistoricalWeatherScreen(WebDriver driver) {
		this.driver = driver;
	}
	
//	static By locationDropdown = By.xpath("//a[@id='locationDropdownMenuButton']");
	static By cityTitle = By.xpath("//div[contains(@class,'align-items-center')]//a[@id='locationDropdownMenuButton']");
	static By justifyContent = By.xpath("//div[@class='row justify-content-center mt-3 mb-3']");
	static By dateRangeDropDown = By.xpath("//button[contains(text(),'Date range')]");
	
	static By cityDropdown = By.xpath("//ul[@class='dropdown-menu p-1 show']//input");
	static By dateRangeToday = By.xpath("//a[contains(text(),'today')]");
	static By maxTempLebel = By.xpath("//div[contains(text(),'Max temp')]");
	static By maxTempDegree = By.xpath("//div[contains(text(),'Max temp')]/following-sibling::div");
	static By celsiusButton = By.xpath("//div[@class='btn-group ms-auto']//button[contains(text(),'C')]");
	static By fahrenheitButton =By.xpath("//div[@class='btn-group ms-auto']//button[contains(text(),'F')]");
	
	static By graphicalGrid = By.xpath("//div[@class='maingrid']");
	static By gridTemp = By.xpath("//div[contains(text(),'Temperature')]");
	static By gridWind = By.xpath("//div[@class='item']//div[contains(text(),'Wind')]");
	static By gridDegreeDays = By.xpath("//div[@class='item'][1]//div[contains(text(),'Degree Days')]");
			
	
	
	public WebElement gridDegreeDays() {
		return driver.findElement(gridDegreeDays);
	}
	
	public WebElement gridWind() {
		return driver.findElement(gridWind);
	}
	
	public WebElement gridTemp() {
		return driver.findElement(gridTemp);
	}
	
	public WebElement graphicalGrid() {
		return driver.findElement(graphicalGrid);
	}
	
	public WebElement cityTitle() {
		return driver.findElement(cityTitle);
	}
	
	public WebElement justifyContent() {
		return driver.findElement(justifyContent);
	}
	
	public WebElement dateRangeDropDown() {
		return driver.findElement(dateRangeDropDown);
	}
	
	public WebElement cityDropdown() {
		return driver.findElement(cityDropdown);
	}
	
	public WebElement dateRangeToday() {
		return driver.findElement(dateRangeToday);
	}
	
	public WebElement maxTempLebel() {
		return driver.findElement(maxTempLebel);
	}
	
	public WebElement maxTempDegree() {
		return driver.findElement(maxTempDegree);
	}
	
	public WebElement celsiusButton() {
		return driver.findElement(celsiusButton);
	}
	
	public WebElement fahrenheitButton() {
		return driver.findElement(fahrenheitButton);
	}

}
