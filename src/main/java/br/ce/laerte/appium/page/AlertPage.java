package br.ce.laerte.appium.page;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;

public class AlertPage extends BasePage {

	public void clicarAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}

	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}

	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
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
