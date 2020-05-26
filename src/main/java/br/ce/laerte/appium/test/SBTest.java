package br.ce.laerte.appium.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.laerte.appium.core.BaseTest;
import br.ce.laerte.appium.page.MenuPage;
import br.ce.laerte.appium.page.seuBarriga.ResumoPage;
import br.ce.laerte.appium.page.seuBarriga.SBContasPage;
import br.ce.laerte.appium.page.seuBarriga.SBHomePage;
import br.ce.laerte.appium.page.seuBarriga.SBLoginPage;
import br.ce.laerte.appium.page.seuBarriga.SBMenuPage;
import br.ce.laerte.appium.page.seuBarriga.SBMovimentacaoPage;

public class SBTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage loginPage = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contasPage = new SBContasPage();
	private SBMovimentacaoPage movimentacaoPage = new SBMovimentacaoPage();
	private SBHomePage homePage = new SBHomePage();
	private ResumoPage resumoPage = new ResumoPage();

	@Before
	public void setup() {
		menu.acessarMenu("SeuBarriga Nativo");
		loginPage.setEmail("lala@a.com");
		loginPage.setSenha("123456");
		loginPage.entrar();
		homePage.reset();
	}

	@Test
	public void inserirContaComSucesso() {
		String nomeConta = "Conta de teste";
		menuSB.acessarAba("CONTAS");
		contasPage.setConta(nomeConta);
		contasPage.salvar();

		Assert.assertTrue(contasPage.existeElementoPorTexto("Conta adicionada com sucesso"));

		// teardown
		contasPage.excluirConta(nomeConta);
	}

	@Test
	public void excluirConta() {
		// Criando massa para excluir
		String nomeConta = "123456";
		menuSB.acessarAba("CONTAS");
		contasPage.setConta(nomeConta);
		contasPage.salvar();
		esperar(1000);

		// Test
		contasPage.excluirConta(nomeConta);
		Assert.assertTrue(contasPage.existeElementoPorTexto("Conta excluída com sucesso"));

	}

	@Test
	public void validarInclusaoMovimentacao() {
		// Setup
		String nomeConta = "Conta para movimentação";
		menuSB.acessarAba("CONTAS");
		contasPage.setConta(nomeConta);
		contasPage.salvar();

		try {
			// Test
			menuSB.acessarAba("MOV...");
			esperar(1000);
			movimentacaoPage.salvar();

			Assert.assertTrue(contasPage.existeElementoPorTexto("Descrição é um campo obrigatório"));
			movimentacaoPage.setValorCampo("Descrição", "Descrição de teste");
			movimentacaoPage.salvar();

			Assert.assertTrue(contasPage.existeElementoPorTexto("Interessado é um campo obrigatório"));
			movimentacaoPage.setValorCampo("Interessado", "Interessado de teste");
			movimentacaoPage.salvar();

			Assert.assertTrue(contasPage.existeElementoPorTexto("Valor é um campo obrigatório"));
			movimentacaoPage.setValorCampo("Valor", "1000");
			movimentacaoPage.salvar();

			Assert.assertTrue(contasPage.existeElementoPorTexto("Conta é um campo obrigatório"));
			movimentacaoPage.setComboConta(nomeConta);
			movimentacaoPage.salvar();

			Assert.assertTrue(contasPage.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
		} catch (Throwable e) {
			// Excluir conta cadastrada em caso de erro
			menuSB.acessarAba("CONTAS");
			contasPage.excluirConta(nomeConta);
			Assert.assertTrue(contasPage.existeElementoPorTexto("Conta excluída com sucesso"));
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void atualizarSaldoExcluirMovimentacao() {
		homePage.reset();
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));

		menuSB.acessarAba("RESUMO");
		esperar(1000);
		resumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");
		Assert.assertTrue(resumoPage.existeElementoPorTexto("Movimentação removida com sucesso!"));

		menuSB.acessarAba("HOME");
		esperar(1000);
		homePage.scroll(0.2, 0.8);
		Assert.assertEquals("-1000.00", homePage.obterSaldoConta("Conta para saldo"));
	}

}
