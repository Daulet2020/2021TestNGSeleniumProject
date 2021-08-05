package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestFor_ID_Locator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.id("disappearing_button" ));
        BrowserUtils.wait(3);
        button.click();
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        driver.close();


    }
}
