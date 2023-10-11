package pruebalmm;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import metodosUtiles.Utiles;
import Navegadores.drivers;
import org.testng.annotations.DataProvider;

public class Pruebalmm {
		WebDriver driver;

		@BeforeMethod()
		public void precondicion() {
			driver=drivers.conectar();
			Utiles.reportes("ir a Wikipedia");
			driver.get("https://www.wikipedia.org/");
		}

		@AfterMethod()
		public void postcondicion() {
			Utiles.reportes("Cerrar navegador");
			driver.close();
		
		}
		@DataProvider(name = "datos")
		public Object[][] createData() {
		return new Object[][] {
		{ "selenium","Selenium"},
		{ "LIONEL MESSI", "Lionel Messi"},
		{"AFA","Asociación del Fútbol Argentino"},
		{"BUENOS AIRES","Buenos Aires"}
		};
		}
		
		@DataProvider(name = "datosDos")
		public Object[][] createDataDos() {
		return new Object[][] {
		{ "SELENIUM","Selenium", "LIONEL MESSI", "Lionel Messi"},
		{"AFA","Asociación del Fútbol Argentino","BUENOS AIRES","Buenos Aires"}
		};
		}
		
		@Test(dataProvider="datos",description = "Validar que las busquedas en Wikipedia funcionan")
		public void ValidarBusquedaWikipedia(String varBuscar, String varResultado) throws Exception {

			Utiles.reportes("Ir a la caja de Busqueda");
			WebElement searchInput = driver.findElement(By.id("searchInput"));

			Utiles.reportes("La caja de Busqueda fue mostrada");
			Assert.assertTrue(searchInput.isDisplayed());

			Utiles.reportes("Se tipea la palabra"+ varBuscar);
			
			searchInput.sendKeys(varBuscar);
		
			Utiles.reportes("Presionar enter");
			searchInput.submit();

			Utiles.reportes("Tiempo de espera de 3 segundos");
			Thread.sleep(2000);

			Utiles.reportes("Identificar titulo de pantalla");
			WebElement tituloResultado = driver.findElement(By.id("firstHeading"));

			Utiles.reportes("Mostrar titulo en consola");
			

			Utiles.reportes("Verificar que se muestre titulo" + varResultado);
			Assert.assertTrue(tituloResultado.isDisplayed());
			
			Assert.assertTrue(tituloResultado.getText().contains(varResultado));

		}

		@Test(dataProvider="datosDos",description = "Validar que se realicen dos busquedas ")
		public void verificaDoblerBusqueda(String varBuscar, String varResultado, String varBuscarDos, String varResultadoDos) throws Exception {

			// buscar elemento searchinput
			Utiles.reportes("Ir a la caja de Busqueda");
			
			WebElement searchInput = driver.findElement(By.id("searchInput"));

			// verificar que se visualice elelemento
			Utiles.reportes("La caja de Busqueda fue mostrada");
			
			Assert.assertTrue(searchInput.isDisplayed());

			// tipear en caja de busqueda
			Utiles.reportes("Se tipea la palabra " + varBuscar);
			
			searchInput.sendKeys(varBuscar);

			// hacer enter en caja de texto
			Utiles.reportes("Presionar enter");
			
			searchInput.submit();
			Thread.sleep(3000);
			WebElement tituloLabel = driver.findElement(By.id("firstHeading"));
			Assert.assertTrue(tituloLabel.getText().contains(varResultado), "No se encontro la Palabra");
			WebElement searchbox = driver.findElement(By.xpath("//input[@id='searchInput']"));
			Assert.assertTrue(searchbox.isDisplayed(), "No se encontro la Palabra");
			searchbox.sendKeys(varBuscarDos);
			searchbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			tituloLabel = driver.findElement(By.id("firstHeading"));
			Assert.assertTrue(tituloLabel.getText().contains(varResultadoDos), "No se encontro la Palabra");

		}
	}

