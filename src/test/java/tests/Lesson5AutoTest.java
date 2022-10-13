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
    public void checkOverweightCaseTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("65");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String overweightText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(overweightText, "Your category is Overweight");
    }
    @Test
    public void checkNormalweightCaseTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String normalText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(normalText, "Your category is Normal");
    }
    @Test
    public void checkUnderweightCaseTest(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name= 'wg']")).sendKeys("40");
        driver.findElement(By.xpath("//input[@name= 'ht']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@value= 'Calculate']")).click();
        String underweightText = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(underweightText, "Your category is Underweight");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
