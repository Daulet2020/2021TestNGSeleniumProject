package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
        BrowserUtils.wait(2);
       }

       @Test (description = "Verify that blue button is selected")
       public void Test1() throws InterruptedException {
        // to go to radio buttons page
           WebElement blueButton = driver.findElement(By.id("blue"));
             Thread.sleep(2000);
           Assert.assertTrue(blueButton.isSelected());
       }
       @Test (description = "Verify that red button not selected")
       public void Test2 (){
           WebElement redButton = driver.findElement(By.id("red"));
           Assert.assertFalse(redButton.isSelected());

       }
       @Test (description = "Verify that green button is not clickable")
       public void Test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
       }
       @Test(description = "Click on all radio buttons")
       public void Test4(){
           List<WebElement> buttons = driver.findElements(By.cssSelector("input[type = 'radio']")) ;
           for (WebElement button: buttons) {
               if (button.isEnabled()&&!button.isSelected()){
                   button.click();
                   System.out.println("Button clicked: "+button.getAttribute("id"));
               }else {
                   System.out.println("Button was not clicked: "+button.getAttribute("id"));
               }
               BrowserUtils.wait(1);
           }

       }

       @AfterMethod
       public void teardown(){
        driver.quit();
       }
}
