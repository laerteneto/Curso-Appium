package br.ce.laerte.appium.page;

import br.ce.laerte.appium.core.BasePage;

public class AlertPage extends BasePage {

	public void clicarAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}

	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}

	public void clicarConfirmar() {
		clicarPorTexto("CONFIRMAR");
	}

	public void clicarSair() {
		clicarPorTexto("SAIR");
	}

	public void clicarForaCaixa() {
		tap(100, 150);
	}

}
