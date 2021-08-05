package tests.day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void teardown (){
        driver.quit();
    }

    @Test (description = "Verify checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox1 is selected");
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"box2\"]"));
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox2 is not selected");

        }
        @Test (description = "Radio buttons test")
    public void test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement BlueButton = driver.findElement(By.xpath("//*[@id=\"blue\"]"));
        // alternative - //*[text()='Blue']/preceding-sibling::input
        Assert.assertTrue(BlueButton.isSelected(), "Blue Button is not selected");



        }



}
