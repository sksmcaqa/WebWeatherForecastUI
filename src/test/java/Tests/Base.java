package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.HistoricalWeatherScreen;
import PageObjectModel.HomeScreen;
import PageObjectModel.WeatherDataScreen;
import Utilities.UtilityFiles;



public class Base {
	WebDriver driver;
	Properties prop;
	SoftAssert assertion;
	HomeScreen homescreen;
	WeatherDataScreen weatherdatascreen;
	HistoricalWeatherScreen weatherForecast;
	
	@BeforeClass
	public void setUp() throws IOException {
		String browser = UtilityFiles.getPropertiesFileData("browser");
		if(browser.equals("chrome"))
			driver = new ChromeDriver();		
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));			
		assertion = new SoftAssert();		
	}
	
	@Test(enabled=true, priority=1)
	public void navigateToWeatherData() throws IOException {
		homescreen = new HomeScreen(driver);
		driver.get(UtilityFiles.getPropertiesFileData("baseUrl"));		
		UtilityFiles.waitById(driver, HomeScreen.modalContent());
		driver.switchTo().activeElement().findElement(HomeScreen.modalContentButton()).click();
		assertion.assertTrue(homescreen.homeScreenTitle().isDisplayed(), "Home Screen Displayed");
		homescreen.weatherDataLink().click();
		assertion.assertAll();
	}
	
	@Test(enabled=true, priority=2)
	public void searchCityWeatherData() throws IOException {		
		weatherdatascreen = new WeatherDataScreen(driver);
		weatherdatascreen.searchInputBox().sendKeys(UtilityFiles.getPropertiesFileData("cityName"));
		weatherdatascreen.searchButton().click();		
	}
	
	@Test(enabled=true, priority=3)
	public void weatherForcastValidation() throws IOException {
		weatherForecast = new HistoricalWeatherScreen(driver);
		if(weatherForecast.cityTitle().getText().contains(UtilityFiles.getPropertiesFileData("cityName")))
			assertion.assertTrue(true, "weather forecast is correctly displaying for the searched city");
		
		if(weatherForecast.dateRangeDropDown().isDisplayed())
			assertion.assertTrue(true, "The date range dropdown is displaying");		
		
		//on clicking user is can see to change city
		weatherForecast.cityTitle().click();
		if(weatherForecast.cityDropdown().isDisplayed())
			assertion.assertTrue(true, "On clicking city name user is can see to change city");

		weatherForecast.dateRangeDropDown().click();
		if(weatherForecast.dateRangeToday().isDisplayed())
			assertion.assertTrue(true, "Today option is displaying under date range dropdown");
		
		if(weatherForecast.maxTempLebel().isDisplayed())
			assertion.assertTrue(true, "Max temp lebel is displaying");
		
		if(weatherForecast.maxTempDegree().isDisplayed())
			assertion.assertTrue(true, "Max temp degree lebel is displaying");				
		
		assertion.assertAll();
	}
	
	@Test(enabled=true, priority=4)
	public void graphicalGridValidation() {
		weatherForecast = new HistoricalWeatherScreen(driver);
		assertion.assertTrue(weatherForecast.graphicalGrid().isDisplayed(), "Graphical grid of weather forcasting is displaying");
		assertion.assertTrue(weatherForecast.gridTemp().isDisplayed(), "Graphical grid level temperature is displaying");
		assertion.assertTrue(weatherForecast.gridWind().isDisplayed(), "Graphical grid level Wind is displaying");
		assertion.assertTrue(weatherForecast.gridDegreeDays().isDisplayed(), "Graphical grid level degree days is displaying");
		
		assertion.assertAll();
	}


@AfterClass
public void closeConnection() {
	driver.quit();
}


}
