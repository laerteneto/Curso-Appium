package br.ce.laerte.appium.core;

import static br.ce.laerte.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	///////// Métodos coringa pouco utilizados
	public void esperaForcada(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/////////// Métodos de escrita
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	/////////// Métodos de retorno de texto
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	/////////// Métodos de cliques
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public void tap(int x, int y) {
		new TouchAction<>(DriverFactory.getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}

	public void tapElement(MobileElement element) {
		int x = element.getLocation().x + (element.getSize().width / 2); // largura
		int y = element.getLocation().y + (element.getSize().height / 2); // altura

		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(x, y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.release()
			.perform();
	}

	public void cliqueLongo(By by) {
		new TouchAction<>(DriverFactory.getDriver())
			.longPress(PointOption.point(getDriver().findElement(by).getCenter()))
			.perform();
	}

	/////////// Métodos de selects, combos, radio, etc
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	/////////// Métodos de verificação
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean isBotaoHabilitado(By by) {
		return getDriver().findElement(by).getAttribute("enabled").equals("true");
	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	///////////// Métodos de alerta/popup

	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}

	//////////// Métodos avançados de scroll, swipe e etc
	public void scroll(double inicio, double fim) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(x, start_y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(x, end_y)))
			.release()
			.perform();
	}

	public void swipe(double inicio, double fim) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(start_x, y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(end_x, y)))
			.release()
			.perform();

	}

	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		scroll(0.1, 0.9);
	}

	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void swipeRigth() {
		swipe(0.9, 0.1);
	}

	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2); // altura

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);

		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(start_x, y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(end_x, y)))
			.release()
			.perform();
	}

}
