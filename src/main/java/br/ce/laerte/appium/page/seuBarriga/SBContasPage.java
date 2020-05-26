package br.ce.laerte.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;

public class SBContasPage extends BasePage {

	public void setConta(String nomeConta) {
		escrever(By.className("android.widget.EditText"), nomeConta);
	}

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='" + conta + "']"));
	}

	public void excluirConta(String conta) {
		selecionarConta(conta);
		clicarPorTexto("EXCLUIR");
	}

}
