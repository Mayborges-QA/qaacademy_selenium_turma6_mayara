package google;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    WebDriver driver;
    @Test

    public void testGoogle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Bolsonaro");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[1]/div/div[2]/div[1]/span")).click();
        Thread.sleep(2000);
        String texto = driver.findElement((By.xpath("//*[@id=\"eer-masthead\"]/div[2]"))).getText();
        Thread.sleep(2000);
        Assert.assertEquals("Texto Invalido", "Resultados das eleições presidenciais de 2022: Brasil", texto);

    }
@After
    public void fecharBrowser(){


        driver.quit();

    }
}
