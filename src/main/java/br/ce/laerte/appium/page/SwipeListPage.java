package br.ce.laerte.appium.page;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {

	public void swipeElementRight(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
	}

	public void swipeElementLeft(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
	}

	public void clicarOpcaoMais(String opcao) {
		clicar(By.xpath("//android.view.ViewGroup//android.widget.TextView[@text='" + opcao + "']"));
	}

	// Necessário, pois o botão foi desenvolvido com um bug em que seu espaço de
	// tela pega o botão menos também
	public void clicarBotaoMais() {
		MobileElement botaoMais = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(DriverFactory.getDriver()).tap(botaoMais, -50, 0).perform();
	}

}
