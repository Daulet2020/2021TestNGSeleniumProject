package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        String title1 = driver.getTitle();
        System.out.println(title1);
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(3);
        driver.getTitle();
        String title2 = driver.getTitle();
        System.out.println(title2);
        if (title1.equals(title2)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

        /*

         */



    }
}
