package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
         driver.findElement(By.name("full_name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys("test_email@mail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        WebElement sub = driver.findElement(By.tagName("h1"));

        System.out.println(sub.getText());



        driver.quit();


    }
}
