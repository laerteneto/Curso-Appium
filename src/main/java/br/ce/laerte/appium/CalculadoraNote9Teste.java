package br.ce.laerte.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraNote9Teste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "290a87e05e3f7ece");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);

		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Plus");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("4 Result preview");

		Assert.assertEquals("4", el4.getText());

		driver.quit();

	}
}
