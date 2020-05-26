package br.ce.laerte.appium.page;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;

public class CliquesPage extends BasePage {

	public void cliqueLongo() {
		cliqueLongo(By.xpath("//android.widget.TextView[@text='Clique Longo']"));
	}

	public void cliqueDuplo() {
		clicarPorTexto("Clique duplo");
		clicarPorTexto("Clique duplo");
	}

	public String obterTextoCampo() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
