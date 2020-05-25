package br.ce.laerte.appium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.CliquesPage;
import br.ce.laerte.appium.page.MenuPage;

public class CliquesTest extends BaseTest {

	MenuPage menu = new MenuPage();
	CliquesPage page = new CliquesPage();

	@Before
	public void setup() {
		menu.acessarMenu("Cliques");
	}

	@Test
	public void deveRealizarCliqueLongo() {
		page.cliqueLongo();
		assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		page.cliqueDuplo();
		assertEquals("Duplo Clique", page.obterTextoCampo());
	}

}
