package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestNGPractice {
    @Test
    public void test(){
        Assert.assertEquals("apple", "apple", "Word is not correct! should be apple ");
   }

   @Test (description = "Verify actual title")
   public void verifyTitle (){
       WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
       String expected = "Practice";
       String actual = driver.getTitle();
       Assert.assertEquals(actual, expected, "Title is wrong");
       BrowserUtils.wait(2);
       driver.quit();

    }

    @Test (description = "Verify heading")
    public void verifyHeadingIsDisplayed (){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        Assert.assertTrue(heading.isDisplayed());
        driver.quit();
     }




}
