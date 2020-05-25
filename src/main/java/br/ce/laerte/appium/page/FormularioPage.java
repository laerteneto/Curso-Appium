package br.ce.laerte.appium.page;

import org.openqa.selenium.By;

import br.ce.laerte.appium.core.BasePage;
import br.ce.laerte.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner//android.widget.TextView"));
	}

	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}

	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}

	public void clicarSeekbar(double posicao) {
		int delta = 55; // Para ajustar a seekbar que começa um pouco depois do x dado pelo uiautomator

		MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);

		int xinicial = seek.getLocation().x + delta;
		int xfinal = (int) ((seek.getSize().width - 2 * delta) * posicao);
		int x = xinicial + xfinal;

		tap(x, y);
	}

	public String obterValorSeekBar() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
	}

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}

	public boolean checarBotaoHabilitado() {
		return isBotaoHabilitado(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	}

	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Console: switch']"));
	}

	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
	}

	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
	}

}
