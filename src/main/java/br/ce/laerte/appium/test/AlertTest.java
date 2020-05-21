package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.AlertPage;
import br.ce.laerte.appium.page.MenuPage;

public class AlertTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertPage page = new AlertPage();

	@Before
	public void setup() {
		menu.acessarAlertas();
	}

	@Test
	public void deveConfirmarAlerta() {
		page.clicarAlertConfirm();
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

		page.clicarConfirmar();
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

		page.clicarSair();
	}

	@Test
	public void deveClicarForaAlerta() {
		page.clicarAlertaSimples();

		esperar(1000);
		page.clicarForaCaixa();
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

	}

}
