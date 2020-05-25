package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.core.DriverFactory;
import br.ce.laerte.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {

	MenuPage menu = new MenuPage();

	@Test
	public void deveEncontrarOpcaoEscondida() {
		// Indo rápido demais, garantir que estará na tela
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

		menu.scrollDown();
		menu.clicarPorTexto("Opção bem escondida");

		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		menu.clicarPorTexto("OK");
	}

}