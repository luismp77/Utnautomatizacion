package testcaset;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import metodosUtiles.Utiles;
import Navegadores.drivers;
import Dataprovider;
public class Tarea4 {
	
	WebDriver driver;
	@BeforeMethod()
	public void precondicion() {
		//Abrimos navegador
		driver = drivers.conectar();
		
		//Ir a wiki 
		Utiles.reportes("ir a Wikipedia");
		driver.get("https://www.wikipedia.org/");
	}

	@AfterMethod()
	public void postcondicion() {
		Utiles.reportes("Cerrar navegador");
		driver.close();
		
		@DataProvider(name = "datos")
		public Object[][] createDatadatos(); {
		return new Object[][]; {
		{ "Selenium","Selenium"},
		{ "TDD", "Desarrollo guiado por pruebas"}
		};
		}
	}
	private void createDatadatos() {
		// TODO Auto-generated method stub
		
	}

	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception {
		
		
		
		//Buscamos el elemento searchinput
		Utiles.reportes("ir a la caja de busqueda");
		
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		
		//Verificamos que elemento se visualize
		Utiles.reportes("La caja de busqueda fue mostrada");
		
		Assert.assertTrue(searchInput.isDisplayed());
		String varbuscar = "SELENIUM";
		
		//Verificamos que el campo de busqueda este vacio 
		Utiles.reportes("El campo se encuentra vacio");
		
		WebElement searchInput1 = driver.findElement(By.id("searchInput"));
		Assert.assertEquals(searchInput1.getText(), "", "El campo esta vacio");
		
		
		//A la caja de texto tipeamos la palabra Selenium
		Utiles.reportes("se tipea la palabra selenium");
		//System.out.println("Se tipe la Palabra selenium");
		searchInput.sendKeys("selenium");
		//searchInput.sendKeys(Keys.TAB);
		
		//Hacemos Enter en la caja de texto
		Utiles.reportes("Se presiona enter");
		
		searchInput.submit();
		Thread.sleep(2000);
		//identificamos el elemento de titulo de la pagina de resultado
		Utiles.reportes("identificamos el elemento del titulo");
		
		
		WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
		
		//mostramos en consola cual es el titulo
		Utiles.reportes("mostramos en consola cual es el titulo");
		
		
		//Verificar que el titulo se muestre
		Utiles.reportes("Verificar que se muestre el titulo");
		
		Assert.assertTrue(tituloResultado.isDisplayed());
		
		//Cerrar navegador.
		Utiles.reportes("Cerrar el navegador");
		
	}
	@Test(description = "Verificar que se realicen dos busquedas")
	public void VerificarDobleBusqueda() throws Exception {
		
		
		
		//Buscamos el elemento searchinput
		Utiles.reportes("ir a la caja de busqueda");
		
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		
		//Verificamos que elemento se visualize
		Utiles.reportes("La caja de busqueda fue mostrada");
		
		Assert.assertTrue(searchInput.isDisplayed());
		
		//A la caja de texto tipeamos la palabra Argentina
		Utiles.reportes("se tipea la palabra Argentina");
		
		searchInput.sendKeys("argentina");
		//searchInput.sendKeys(Keys.TAB);
		
	
		//Hacemos Enter en la caja de texto
		Utiles.reportes("Se presiona enter");
		
		searchInput.submit();
		Thread.sleep(3000);
		
		WebElement titulolabel = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (titulolabel.getText().contains("Argentina"),"no se encontro la palabra");
		WebElement CajadeBusqueda= driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (CajadeBusqueda.isDisplayed(),"no se encontro la palabra argentina");
		
		
		
	}
	@Test(description = "Verificar que se realicen tres busquedas")
	public void VerificarTripleBusqueda() throws Exception {
		
		
		
		
		//Buscamos el elemento searchinput
		Utiles.reportes("ir a la caja de busqueda");
		
		
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		
		//Verificamos que elemento se visualize
		Utiles.reportes("La caja de busqueda fue mostrada");
		
		Assert.assertTrue(searchInput.isDisplayed());
		
		//A la caja de texto tipeamos la palabra leon
		Utiles.reportes("se tipea la palabra leon");
		
		searchInput.sendKeys("Leon");
		//searchInput.sendKeys(Keys.TAB);
		
		
		
		//Hacemos Enter en la caja de texto
		Utiles.reportes("Se presiona enter");
		
		searchInput.submit();
		Thread.sleep(3000);
		
		WebElement titulo = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (titulo.getText().contains("Panthera leo"),"no se encontro la palabra");
		WebElement CajadeBusquedaa= driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (CajadeBusquedaa.isDisplayed(),"no se encontro la palabra leon");
		
		//Cerrar navegador.
				Utiles.reportes("Cerrar el navegador");
				
		
	}@Test(description = "Verificar que se realicen busquedas en Amor")
	public void VerificarttTripleBusqueda() throws Exception {
	
		
		//Buscamos el elemento searchinput
		Utiles.reportes("ir a la caja de busqueda");
		
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		
		//Verificamos que elemento se visualize
		Utiles.reportes("La caja de busqueda fue mostrada");
		
		Assert.assertTrue(searchInput.isDisplayed());
		
		//A la caja de texto tipeamos la palabra Amor
		Utiles.reportes("se tipea la palabra leon");
		
		searchInput.sendKeys("Amor");
		searchInput.sendKeys(Keys.TAB);
		
		
		
		//Hacemos Enter en la caja de texto
		Utiles.reportes("Se presiona enter");
		
		searchInput.submit();
		Thread.sleep(3000);
		
		WebElement titulod = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (titulod.getText().contains("Amor"),"no se encontro la palabra");
		WebElement CajadeBusquedaaa= driver.findElement(By.id("firstHeading"));
		Assert.assertTrue (CajadeBusquedaaa.isDisplayed(),"no se encontro la palabra Amor");
	}
		
		
	

	@Test(description = "Verificar que se muestre Logo de wikipedia")
	public void VerificarLogo() throws Exception {
		
				//Verificamos que se muestre texto logo
				Utiles.reportes("Verificamos Logo");
		
				WebElement logowikipedia = driver.findElement(By.xpath("//span[@class='central-textlogo__image sprite svg-Wikipedia_wordmark']"));
				Assert.assertTrue (logowikipedia.isDisplayed(),"no se encontro el logo");
				
	}
}