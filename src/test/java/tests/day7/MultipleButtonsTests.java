package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class MultipleButtonsTests {
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
    }

    @Test
    public void verifyButton1() {
        String expectedResult = "Clicked on button one!";
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Result wrong");
    }

    @Test
    public void verifyButton2() {
        String expectedResult = "Clicked on button two!";
        driver.findElement(By.name("button2")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Result wrong");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
