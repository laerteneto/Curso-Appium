package br.ce.laerte.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
			//createTestObjectDriver();
		}

		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "F:\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");

		URL remoteUrl = null;
		try {
			remoteUrl = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	private static void createTestObjectDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("testobject_api_key", "15915195C159195CSDAFG981981918");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appiumVersion", "1.7.2");

		URL remoteUrl = null;
		try {
			remoteUrl = new URL("https://us1.appium.testobject.com/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
