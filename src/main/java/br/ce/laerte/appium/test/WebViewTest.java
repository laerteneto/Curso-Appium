package br.ce.laerte.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.MenuPage;
import br.ce.laerte.appium.page.WebViewPage;

public class WebViewTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Before
	public void setup() {
		menu.acessarSBHibrido();
		esperar(5000);
		page.entrarContextoWeb();
	}

	@After
	public void tearDown() {
		page.sairContextoWeb();
	}

	@Test
	public void deveFazerLogin() {
		page.setEmail("laerteteste@hotmail.com");
		page.setSenha("123456");
		page.clicarEntrar();

		Assert.assertEquals("Bem vindo, Laerte!", page.obterMensagemLoginSucesso());
	}
}
