package myFirstAppuim;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest 
{
	private static DesiredCapabilities mobile_capaility = new DesiredCapabilities();
	public static AndroidDriver CapabilitieSetUp(String platform, String platformVersion,
			String udid, String appPackage,String appActivity,String automationName,String url) 
					throws MalformedURLException
	{
		
			mobile_capaility.setCapability("deviceName","Android");
			mobile_capaility.setCapability("platformVersion", platformVersion);
			mobile_capaility.setCapability("udid", udid);
			mobile_capaility.setCapability("appPackage", appPackage);
			mobile_capaility.setCapability("appActivity",appActivity);
			mobile_capaility.setCapability("automationName",automationName);
			AndroidDriver driver = new AndroidDriver(new URL(url), mobile_capaility);
			return driver;
	

	}
	
}
