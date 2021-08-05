package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //      syntax [attribute *= 'value']
        //      [class="btn btn-primary"]
        //      [id*='d']  using id and character in text
        //      [id^='button_'] using ^ if second part of text is dynamic
        //      [id$='end_of_value] | $ means attribute with value
        /*
                                * - contains
                                ^ - starts with
                                $ - ends with
         */

        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (WebElement but : buttons) {
            but.click();
            BrowserUtils.wait(1);
            WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }
        BrowserUtils.wait(1);
        driver.quit();

    }
}
