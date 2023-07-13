package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilityFiles {
	
	public static void waitById(WebDriver driver, By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	
//	public static void clickElementByJavaScript(WebDriver driver, By id) {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", driver.findElement(id));
//	}
	
	public static String getPropertiesFileData(String propKey) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//globalData.properties");
		prop.load(fis);
		String value = prop.getProperty(propKey);
		return value;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
//		
//	}
	
}




