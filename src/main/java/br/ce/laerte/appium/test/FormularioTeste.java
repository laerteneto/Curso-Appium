package br.ce.laerte.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.core.DriverFactory;
import br.ce.laerte.appium.page.FormularioPage;
import br.ce.laerte.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePrencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Laerte");
		Assert.assertEquals("Laerte", page.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		// clicar no combo
		page.selecionarCombo("Nintendo Switch");

		// verificar a opção selecionada
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// verificar status dos elementos
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		// verificar status alterados
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException, InterruptedException {
		// Preecher campos
		page.escreverNome("Laerte");
		page.selecionarCombo("Nintendo Switch");
		page.clicarCheck();
		page.clicarSwitch();

		// verificar status dos elementos
		Assert.assertEquals("Laerte", page.obterNome());
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

		// Salvar
		page.salvar();
		Thread.sleep(1000); // gambs
		Assert.assertFalse(page.checarBotaoHabilitado());

		// Validações
		Assert.assertEquals("Nome: Laerte", page.obterNomeCadastrado());

		Assert.assertEquals("Nome: Laerte", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertEquals("Checkbox: Marcado", page.obterCheckCadastrado());
		Assert.assertEquals("Switch: Off", page.obterSwitchCadastrado());
	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException, InterruptedException {
		page.escreverNome("Laerte");

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		page.salvarDemorado();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Laerte']")));
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Assert.assertEquals("Nome: Laerte", page.obterNomeCadastrado());

	}

	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}

	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}

}
