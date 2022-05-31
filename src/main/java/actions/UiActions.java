package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;


public class UiActions
{
	public AndroidDriver driver;
	public UiActions(AndroidDriver driver) 
	{
		this.driver = driver;
	}

	public WebElement find(By elementlocator)
	{
		return driver.findElement(elementlocator);
	}

	public void oneClick(By element) {
		WebElement currentElement = find(element);
		currentElement.click();
	}

	public void type(By element,String text) {
		WebElement currentElement = find(element);
		currentElement.clear();
		currentElement.sendKeys(text);
	}
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	public void click (By locator)
	{
		find(locator).click();
	}
	public Boolean isDisplayed (By locator)
	{
		try
		{
			System.out.println(locator.toString());
			return find(locator).isDisplayed();
		}
		catch (NoSuchElementException exc) 
		{
			return false;
		}
	}
	public void waitForDisplay(By submitAccount)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(submitAccount));
	
	}
	public String waits(By element)
	{
		Wait wait = new WebDriverWait(driver, 10);
		WebElement e = find(element);
	    wait.until(ExpectedConditions.visibilityOf(e));
	    return (e.getText());
	}

}
