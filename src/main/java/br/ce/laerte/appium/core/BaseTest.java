package br.ce.laerte.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName(); // obter parametros do test para utilizar no screenshot depois

	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().resetApp(); // Agilizar na velocidade entre os testes. Ao invez de fechar, faz isso
	}

	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
