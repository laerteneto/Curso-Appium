package br.ce.laerte.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao(String descricao) {
		clicarPorTexto("ATUALIZAR");
		esperaForcada(1000);
		MobileElement element = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + descricao + "']/.."));
		swipeElement(element, 0.9, 0.1);
		clicarPorTexto("Del");
	}

}
