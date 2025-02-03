package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CommonActionPages {
    protected WebDriver driver;
    public CommonActionPages(WebDriver driver){
        this.driver=driver;

    }
    public WebDriver chromeDriverConexion(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public void visitarPagina(String enlace){
        driver.get(enlace);
        driver.manage().window().maximize();
    }
    public void limpiarCajaTexto(By localizador){
        driver.findElement(localizador).clear();
    }
    public void Presionar(By localizador){
        WebElement elemento = driver.findElement(localizador);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        elemento.click();
    }
    public void escribirTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }
    public void seleccionar(By localizador, String valor){
        Select dia = new Select(driver.findElement(localizador));
        dia.selectByValue(String.valueOf(valor));
    }
    public void enviarTexto(By localizador){
        driver.findElement(localizador).submit();
    }
    public void esperarTiempo(int tiempo){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tiempo));
    }
    public String obtenerTitulo(){
        return driver.getTitle();
    }
    public String obtenerTexto(By localizador){
        WebElement text = driver.findElement(localizador);
        return text.getText();
    }

}
