package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.MenuPage;
import br.ce.laerte.appium.page.SwipeListPage;

public class SwipeListTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Before
	public void setup() {
		menu.scrollDown();
		menu.acessarMenu("Swipe List");
	}

	@Test
	public void deveInteragirComLista() {
		page.swipeElementRight("Opção 1");
		page.clicarBotaoMais();
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

		page.swipeElementRight("Opção 4");
		page.clicarPorTexto("(-)");
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

		page.swipeElementLeft("Opção 5 (-)");
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

	}

}
