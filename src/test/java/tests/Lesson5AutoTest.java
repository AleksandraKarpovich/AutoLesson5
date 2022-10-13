package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Lesson5AutoTest {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void OverweightTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("65");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String OverweightText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(OverweightText, "Your category is Overweight");
    }
    @Test
    public void NormalTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String NormalText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(NormalText, "Your category is Normal");
    }
    @Test
    public void UnderweightTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("40");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String UnderweightText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(UnderweightText, "Your category is Underweight");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
