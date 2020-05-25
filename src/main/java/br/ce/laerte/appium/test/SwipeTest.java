package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.MenuPage;
import br.ce.laerte.appium.page.SwipePage;

public class SwipeTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipePage page = new SwipePage();

	@Before
	public void setup() {
		menu.acessarMenu("Swipe");
	}

	@Test
	public void deveRealizarSwipe() {
		Assert.assertTrue(page.existeElementoPorTexto("a esquerda"));

		page.swipeRigth();
		Assert.assertTrue(page.existeElementoPorTexto("E veja se"));

		page.clicarPorTexto("›");
		Assert.assertTrue(page.existeElementoPorTexto("Chegar até o fim!"));

		page.swipeLeft();
		page.clicarPorTexto("‹");
		Assert.assertTrue(page.existeElementoPorTexto("a esquerda"));
	}

}
