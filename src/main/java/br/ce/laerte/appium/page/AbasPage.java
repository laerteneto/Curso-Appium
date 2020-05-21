package br.ce.laerte.appium.page;

import br.ce.laerte.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}

	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}

	public void selecionarAba2() {
		clicarPorTexto("ABA 2");
	}

}
