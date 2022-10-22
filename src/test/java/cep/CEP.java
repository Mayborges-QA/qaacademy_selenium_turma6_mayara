package cep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class CEP {
    WebDriver driver;

    @Test

    public void testCEP() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("endereco")).sendKeys("06622180");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btn_pesquisar\"]")).click();
        Thread.sleep(2000);
        String texto = driver.findElement((By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]"))).getText();
        Thread.sleep(2000);
        Assert.assertEquals("Texto Invalido", "Rua Ancião Sebastião Antonini", texto);

    }
    @Test
    public void testCEPLista() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("endereco")).sendKeys("06622180");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"tipoCEP\"]")).click();
        Thread.sleep(2000);
        Select TipoCEP = new Select(driver.findElement(By.xpath("//*[@id=\"tipoCEP\"]")));
        TipoCEP.selectByVisibleText("Localidade/Logradouro");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btn_pesquisar\"]")).click();
        Thread.sleep(2000);
        String texto = driver.findElement((By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]"))).getText();
        Thread.sleep(2000);
        Assert.assertEquals("Texto Invalido", "Rua Ancião Sebastião Antonini", texto);
    }
    @After
    public void fecharBrowser() {


        driver.quit();

    }
}
