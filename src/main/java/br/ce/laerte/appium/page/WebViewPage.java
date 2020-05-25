package br.ce.laerte.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;

public class WebViewPage extends BasePage {

	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();

		// for (String valor : contextHandles)
		// System.out.println(valor);

		DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
	}

	public void sairContextoWeb() {
		DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[0]);
	}

	public void setEmail(String valor) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
	}

	public void setSenha(String valor) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(valor);
	}

	public void clicarEntrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String obterMensagemLoginSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
