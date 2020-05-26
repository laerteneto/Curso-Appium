package br.ce.laerte.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public void setValorCampo(String campo, String valor) {
		escrever(By.xpath("//android.widget.EditText[@text='" + campo + "']"), valor);
	}

	public void setComboConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
	}

}