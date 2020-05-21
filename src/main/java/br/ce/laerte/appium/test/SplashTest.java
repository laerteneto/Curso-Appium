package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.MenuPage;
import br.ce.laerte.appium.page.SplashPage;

public class SplashTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();

	@Test
	public void deveAguardarSplashSumir() {
		menu.acessarSplash();
		Assert.assertTrue(page.isTelaSplashVisivel());

		page.aguardarSplashSumir();
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}

}
