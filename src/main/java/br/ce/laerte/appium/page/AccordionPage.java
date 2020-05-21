package br.ce.laerte.appium.page;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void clicarOpcao(String opcao) {
		clicarPorTexto(opcao);
	}

	public String obterValorOpcao(String opcao) {
		return obterTexto(By.xpath("//*[@text='" + opcao + "']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}

}
