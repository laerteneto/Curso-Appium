package br.ce.laerte.appium.core;

import static br.ce.laerte.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	/////////// Métodos de escrita
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	/////////// Métodos de retorno de texto
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	/////////// Métodos de cliques
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	/////////// Métodos de selects, combos, radio, etc
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	/////////// Métodos de verificação
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean isBotaoHabilitado(By by) {
		return getDriver().findElement(by).getAttribute("enabled").equals("true");
	}

}