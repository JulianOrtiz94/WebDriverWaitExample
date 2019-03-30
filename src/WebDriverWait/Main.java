package WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.google.com.uy");
		
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated((By.name("q"))));
		
		driver.findElement(By.name("q")).sendKeys("Selenium get screenshot java");;
		driver.findElement(By.name("btnK")).submit();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		 
	    try {
	        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\SELENIUM\\WebDriverWait\\Screenshot.png"));
	    } catch (WebDriverException e) {
	 
	    } catch (IOException e) {
	 
	    }
	    
	    driver.quit();
	}

}
