package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.AbasPage;
import br.ce.laerte.appium.page.MenuPage;

public class AbasTest extends BaseTest {

	MenuPage menu = new MenuPage();
	AbasPage page = new AbasPage();

	@Test
	public void deveInteragircomAbas() {
		menu.acessarAbas();
		Assert.assertTrue(page.isAba1());
		page.selecionarAba2();
		Assert.assertTrue(page.isAba2());
	}

}
