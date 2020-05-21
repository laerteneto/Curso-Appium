package br.ce.laerte.appium.page;

import br.ce.laerte.appium.core.BasePage;

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

}
