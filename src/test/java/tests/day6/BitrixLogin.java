package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //                          //*input[starts-with(@value,'Log')]
        //                          //*[contains(text(),'Incorrect')]
        //                          //*[contains(@title, 'Activity Stream')]
        //                          //*[contains(@id, 'blg-post')]


        //                          //button[3] --> 3-th ch ild

        //          To go to parent element:/..
        //          Example:
        //          //*[text()='Text]/..       | from the text to parent elemen t

        driver.quit();

    }
}
