package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTestPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys("text@email.com", Keys.ENTER); // different way to click on button
        //   WebElement button = driver.findElement(By.id("form_submit"));
        //   button.click();
        String expected = "http://practice.cybertekschool.com/email_sent";
        String actual = driver.getCurrentUrl();
        if(actual.equals(expected)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed ");
        }
        BrowserUtils.wait(2);
        WebElement message = driver.findElement(By.name("confirmation_message"));
        String text = "Your e-mail's been sent!";
        String text1 = message.getText();
        if(text.equals(text1)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }



        driver.close();








    }
}
