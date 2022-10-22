package register;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
    WebDriver driver;

    @Test
    public void registerTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.findElement(By.name("First Name")).sendKeys("Mayara");
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

