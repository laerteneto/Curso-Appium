package br.ce.laerte.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.FormularioPage;
import br.ce.laerte.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePrencherCampoTexto() throws MalformedURLException {
		formulario.escreverNome("Laerte");
		Assert.assertEquals("Laerte", formulario.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		// clicar no combo
		formulario.selecionarCombo("Nintendo Switch");

		// verificar a opção selecionada
		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// verificar status dos elementos
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());

		formulario.clicarCheck();
		formulario.clicarSwitch();

		// verificar status alterados
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException, InterruptedException {
		// Preecher campos
		formulario.escreverNome("Laerte");
		formulario.selecionarCombo("Nintendo Switch");
		formulario.clicarCheck();
		formulario.clicarSwitch();

		// verificar status dos elementos
		Assert.assertEquals("Laerte", formulario.obterNome());
		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());

		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

		// Salvar
		formulario.salvar();
		Thread.sleep(1000); // gambs
		Assert.assertFalse(formulario.checarBotaoHabilitado());

		// Validações
		Assert.assertEquals("Nome: Laerte", formulario.obterNomeCadastrado());

		Assert.assertEquals("Nome: Laerte", formulario.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", formulario.obterConsoleCadastrado());
		Assert.assertEquals("Checkbox: Marcado", formulario.obterCheckCadastrado());
		Assert.assertEquals("Switch: Off", formulario.obterSwitchCadastrado());
	}

}
