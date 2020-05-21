package br.ce.laerte.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.AccordionPage;
import br.ce.laerte.appium.page.MenuPage;

public class AccordionTest extends BaseTest {

	MenuPage menu = new MenuPage();
	AccordionPage page = new AccordionPage();

	@Test
	public void deveInteragirComAccordion() {
		menu.acessarMenu("Accordion");
		page.clicarOpcao("Opção 1");

		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOpcao("Opção 1"));
	}

}
