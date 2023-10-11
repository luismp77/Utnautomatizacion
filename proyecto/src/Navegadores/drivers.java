package Navegadores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import metodosUtiles.Utiles;

public class drivers {
	public static WebDriver conectar() {
		Utiles.reportes("Se abre Navegador");
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
