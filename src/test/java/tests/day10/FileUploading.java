package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;


public class FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test (description = "Verify that file was uploaded")
    public void Test1(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\daule\\OneDrive\\Desktop\\image.jpg");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(2);
        String expected = "image.jpg";
        String actual = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual, expected);

    }

}
