package myFirstAppuim;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BaseScreen.Calculator;
import actions.UiActions;
import io.appium.java_client.android.AndroidDriver;

public class FloatingNumberTest extends BaseTest
{
	static UiActions myUi;
	static Calculator cal ;
	@BeforeClass
	public void setCab() throws MalformedURLException
	{
		
		AndroidDriver driver = BaseTest.CapabilitieSetUp("Andriod","12","dd33c497", "com.miui.calculator",
				"com.miui.calculator.cal.CalculatorActivity","Appium","http://0.0.0.0:4723/wd/hub"); 
		myUi = new UiActions(driver);
		cal = new Calculator(myUi);
	}
	@Test
	public static void floatSum() throws MalformedURLException
	{
		
		cal.sumFloating();
		Assert.assertEquals(cal.getResult(),Float.parseFloat("6.4"));
	}


}
