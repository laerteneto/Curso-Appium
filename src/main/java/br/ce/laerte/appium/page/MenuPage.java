package br.ce.laerte.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;

public class MenuPage extends BasePage {

	public void acessarMenu(String menu) {
		clicarPorTexto(menu);
	}

	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}

	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");
	}

	public void acessarDragDrop() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public void acessarSBHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}

}
