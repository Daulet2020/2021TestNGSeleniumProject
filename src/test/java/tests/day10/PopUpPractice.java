package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }
    @AfterMethod
    public void teardown (){
        driver.quit();
    }


    @Test (description = "Click OK on button 1 in pop up message")
    public void Test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept(); // to click on the button "Ok"
        BrowserUtils.wait(2);
    }

    @Test(description = "Click on button 2 and click on Cancel in pop up message")
        public void Test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        //print text of pop up message
        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(2);
        //to print text of result
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test (description = "Click on button 3, enter some text and then click OK")
    public void Test3 (){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[3]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is cool");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());


    }

}
