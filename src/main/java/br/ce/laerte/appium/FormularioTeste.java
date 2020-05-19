package br.ce.laerte.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void devePrencherCampoTexto() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "F:\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\campo_treinamento.apk");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// selecionar formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

		for (MobileElement elemento : elementosEncontrados) {
			if (elemento.getText().equals("Formulário")) {
				elemento.click();
				break;
			}
		}

		// Por index era assim, mas se mudasse a ordem dos menus, quebrava.
		// elementosEncontrados.get(1).click();

		// escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Laerte");

		// checar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Laerte", text);

		driver.quit();

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "F:\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\campo_treinamento.apk");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// selecionar formulario
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// verificar a opção selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner//android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);

		driver.quit();

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "F:\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\campo_treinamento.apk");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// selecionar formulario
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

		// verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));

		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));

		// clicar nos elementos
		check.click();
		switc.click();

		// verificar status alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));

		driver.quit();

	}

	@Test
	public void devePreencherFormulario() throws MalformedURLException, InterruptedException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "F:\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\campo_treinamento.apk");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// selecionar formulario
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

		// Preecher campos
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Laerte");
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		driver.findElement(By.xpath("//*[@text='Nintendo Switch']")).click();
		driver.findElement(MobileBy.AccessibilityId("check")).click();
		driver.findElement(MobileBy.AccessibilityId("switch")).click();

		// verificar status dos elementos
		String nome = driver.findElement(MobileBy.AccessibilityId("nome")).getText();
		Assert.assertEquals("Laerte", nome);

		String produto = driver.findElement(By.xpath("//android.widget.Spinner//android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", produto);

		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(switc.getAttribute("checked").equals("false"));

		// Salvar
		MobileElement btnSalvar = driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']"));
		btnSalvar.click();
		Thread.sleep(1000); // gambs
		Assert.assertTrue(btnSalvar.getAttribute("enabled").equals("false"));

		// Validaçãoes
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")).getText(), "Nome: Laerte");
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Console: switch']")).getText(), "Console: switch");
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText(), "Switch: Off");
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText(), "Checkbox: Marcado");

		driver.quit();

	}

}
